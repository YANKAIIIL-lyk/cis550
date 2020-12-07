package com.example.cis550.dao;

import com.example.cis550.entity.BB200Entity;
import com.example.cis550.entity.BB200EntityPK;
import com.example.cis550.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BB200Dao extends JpaRepository<BB200Entity, BB200EntityPK> {

    @Query(value = "SELECT new com.example.cis550.model.Song(g.songName, g.genre)" +
            "FROM GrammySongsEntity g JOIN RiaaSingleEntity r ON g.songName = r.songName WHERE g.songName = r.songName AND g.grammyYear >= ?1 AND g.grammyYear <= ?2")
    List<Song> findAllSong(int start, int end);

}
