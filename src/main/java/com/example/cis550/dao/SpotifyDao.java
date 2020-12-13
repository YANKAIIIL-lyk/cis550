package com.example.cis550.dao;

import com.example.cis550.entity.SpotifyEntity;
import com.example.cis550.entity.SpotifyEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotifyDao extends JpaRepository<SpotifyEntity, SpotifyEntityPK> {

}
