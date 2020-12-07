package com.example.cis550.dao;

import com.example.cis550.entity.RiaaSingleEntity;
import com.example.cis550.entity.RiaaSingleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiaaSingleDao extends JpaRepository<RiaaSingleEntity, RiaaSingleEntityPK> {

}
