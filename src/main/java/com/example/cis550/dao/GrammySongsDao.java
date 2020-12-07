package com.example.cis550.dao;

import com.example.cis550.entity.GrammySongsEntity;
import com.example.cis550.entity.GrammySongsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammySongsDao extends JpaRepository<GrammySongsEntity, GrammySongsEntityPK> {
}
