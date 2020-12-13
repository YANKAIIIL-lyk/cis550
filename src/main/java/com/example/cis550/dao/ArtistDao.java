package com.example.cis550.dao;

import com.example.cis550.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistDao extends JpaRepository<ArtistEntity, String> {

    @Query(value = "SELECT * FROM Artist WHERE Genres LIKE ?1", nativeQuery = true)
    List<ArtistEntity> findAllSimilar(String filter);

}
