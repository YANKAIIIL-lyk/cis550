package com.example.cis550.service;

import com.example.cis550.dao.GrammySongsDao;
import com.example.cis550.dao.RiaaSingleDao;
import com.example.cis550.entity.GrammyAlbumsEntity;
import com.example.cis550.entity.GrammySongsEntity;
import com.example.cis550.entity.RiaaSingleEntity;
import com.example.cis550.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtistService {

    @Autowired
    private GrammySongsDao grammySongsDao;
    @Autowired
    private RiaaSingleDao riaaSingleDao;

    public List<Artist> findMostProlific(){
        List<GrammySongsEntity> grammyArtists = grammySongsDao.findAll();
        List<RiaaSingleEntity> riaaArtists = riaaSingleDao.findAll();
        Map<String, Integer> count = new HashMap<>();
        grammyArtists.stream().forEach(e -> {
            String key = e.getArtist().toLowerCase();
            count.put(key, count.getOrDefault(key, 0) + 1);
        });
        riaaArtists.stream().forEach(e -> {
            String key = e.getArtist().toLowerCase();
            count.put(key, count.getOrDefault(key, 0) + 1);
        });
        List<Artist> list = new ArrayList<>();
        count.entrySet().forEach(e -> list.add(Artist.builder().artist(e.getKey()).count(e.getValue()).build()));
        //Suppose the result is in descending order
        Collections.sort(list, (o1, o2) -> o2.getCount() - o1.getCount());
        return list;
    }

}
