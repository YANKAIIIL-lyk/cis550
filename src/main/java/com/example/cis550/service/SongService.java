package com.example.cis550.service;

import com.example.cis550.dao.BB200Dao;
import com.example.cis550.entity.BB200Entity;
import com.example.cis550.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private BB200Dao bb200Dao;

    public List<BB200Entity> findAllGrammySongs(){
        List<BB200Entity> entities = bb200Dao.findAll();
        return entities;
    }

    public List<Song> findRange(String start, String end){
        List<Song> songs = bb200Dao.findAllSong(Integer.parseInt(start), Integer.parseInt(end));
        return songs;
    }

}
