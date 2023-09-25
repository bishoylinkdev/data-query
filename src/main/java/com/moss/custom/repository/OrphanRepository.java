package com.moss.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.custom.model.orphan.Orphan;

@Repository
public interface OrphanRepository extends JpaRepository<Orphan, Long>{

}
