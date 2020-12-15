package com.example.cis550.service;

import com.example.cis550.dao.*;
import com.example.cis550.entity.BB200Entity;
import com.example.cis550.entity.SpotifyEntity;
import com.example.cis550.model.RecommendView;
import com.example.cis550.model.Song;
import com.example.cis550.model.TopGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private BB200Dao bb200Dao;

    @Autowired
    private GrammySongsDao grammySongsDao;

    @Autowired
    private RiaaSingleDao riaaSingleDao;

    @Autowired
    private SpotifyDao spotifyDao;

    @Autowired
    private ArtistDao artistDao;

    public List<BB200Entity> findAllGrammySongs() {
        List<BB200Entity> entities = bb200Dao.findAll();
        return entities;
    }

    public List<Song> findRange(String start, String end) {
        List<Song> songs = bb200Dao.findAllSong(Integer.parseInt(start), Integer.parseInt(end));
        return songs;
    }

    public List<TopGenre> findTopGenre(int year, String genre, boolean sort) {
        String filter = "%" + genre + "%";
        List<TopGenre> topSongs = bb200Dao.findAllSongInTopGenre(year, filter);
        if (sort) {
            Collections.sort(topSongs, (o1, o2) -> o1.getSongName().compareTo(o2.getSongName()));
        }
        return topSongs;
    }

    public List<Song> hidden(String start, String end) {
        int startYear = Integer.parseInt(start);
        int endYear = Integer.parseInt(end);
        List<Song> popularSongs = bb200Dao.findBBSpotify();
        Set<String> grammy = grammySongsDao.findAll().stream()
                .map(e -> e.getSongName()).collect(Collectors.toSet());
        Set<String> riaa = riaaSingleDao.findAll().stream()
                .map(e -> e.getSongName()).collect(Collectors.toSet());
        List<Song> res = new ArrayList<>();
        popularSongs.stream().forEach(e -> {
            String song = e.getSongName();
            int year = e.getYear();
            if (!grammy.contains(song) && !riaa.contains(song) && year >= startYear && year <= endYear) {
                res.add(e);
            }
        });
        return res;
    }

    public List<Song> exclusive(String start, String end) {
        int startYear = Integer.parseInt(start);
        int endYear = Integer.parseInt(end);
        List<SpotifyEntity> spotifySearch = spotifyDao.findAll();
        Set<SpotifyEntity> spotifyEntities = new HashSet<>();
        for (SpotifyEntity spotifyEntity : spotifySearch) {
            String s = spotifyEntity.getWeek().split("-")[0];
            int year = Integer.parseInt(s);
            if (year >= startYear && year <= endYear) {
                spotifyEntities.add(spotifyEntity);
            }
        }
        Set<String> bb200EntitiesName = bb200Dao.findAll().stream()
                .map(e -> e.getAlbumName()).collect(Collectors.toSet());
        List<Song> res = new ArrayList<>();
        for (SpotifyEntity spotifyEntity : spotifyEntities) {
            String name = spotifyEntity.getName();
            if (bb200EntitiesName.contains(name)) {
                continue;
            }
            int year = Integer.parseInt(spotifyEntity.getWeek().split("-")[0]);
            Song song = Song.builder().songName(spotifyEntity.getName())
                    .artists(spotifyEntity.getArtist()).year(year).build();
            res.add(song);
        }
        return res;
    }

    public List<RecommendView> recommend(String genre) {
        String filter = "%" + genre + "%";
        Set<String> artistNames = artistDao.findAllSimilar(filter).stream()
                .map(e -> e.getArtist()).collect(Collectors.toSet());
        List<SpotifyEntity> spotifyEntities = spotifyDao.findAll().stream()
                .filter(e -> artistNames.contains(e.getArtist())).collect(Collectors.toList());
        //key is the artist's name and value is a pair, from the songName to the streams
        Map<String, Pair<String, Integer>> map = new HashMap<>();
        for (String artist : artistNames) {
            map.put(artist, new Pair<>("", -1));
        }
        for (SpotifyEntity spotifyEntity : spotifyEntities) {
            String songName = spotifyEntity.getName();
            String artist = spotifyEntity.getArtist();
            if(artistNames.contains(artist)){
                int count = spotifyEntity.getStreams();
                int curr = map.get(artist).getValue();
                if (count >= curr) {
                    Pair pair = map.get(artist);
                    pair.setKey(songName);
                    pair.setValue(count);
                }
            }
        }
        Set<Map.Entry<String, Pair<String, Integer>>> entries = map.entrySet();
        List<RecommendView> views = new ArrayList<>();
        entries.forEach(e -> {
            String artist = e.getKey();
            String song = e.getValue().getKey();
            int streams = e.getValue().getValue();
            if(streams > 0){
                RecommendView view = RecommendView.builder().artist(artist)
                        .song(song).streams(streams).build();
                views.add(view);
            }
        });
        Collections.sort(views, (o1, o2) -> o2.getStreams() - o1.getStreams());
        return views;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Pair<K, V> {
    private K key;
    private V value;
}

