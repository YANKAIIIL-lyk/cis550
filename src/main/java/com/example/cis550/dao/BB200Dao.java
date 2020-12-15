package com.example.cis550.dao;

import com.example.cis550.entity.BB200Entity;
import com.example.cis550.entity.BB200EntityPK;
import com.example.cis550.model.Song;
import com.example.cis550.model.TopGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BB200Dao extends JpaRepository<BB200Entity, BB200EntityPK> {

    @Query(value = "SELECT DISTINCT new com.example.cis550.model.Song(g.songName, g.artist, g.genre, g.grammyYear)" +
            "FROM GrammySongsEntity g JOIN RiaaSingleEntity r ON g.songName = r.songName " +
            "WHERE g.songName = r.songName AND g.grammyYear >= ?1 AND g.grammyYear <= ?2")
    List<Song> findAllSong(int start, int end);

    @Query(value = "SELECT DISTINCT new com.example.cis550.model.TopGenre(b.albumName, b.artists, b.genre, b.date)" +
            "FROM BB200Entity b " +
            "WHERE b.date = ?1 AND b.genre LIKE ?2")
    List<TopGenre> findAllSongInTopGenre(int year, String filter);

    @Query(value = "SELECT DISTINCT new com.example.cis550.model.Song(bb.albumName, bb.artists, bb.genre, bb.date) " +
            "FROM BB200Entity bb JOIN SpotifyEntity spot on bb.albumName = spot.name " +
            "WHERE bb.albumName = spot.name AND bb.artists = spot.artist")
    List<Song> findBBSpotify();

}
