package com.moss.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.custom.model.aid.AidType;

@Repository
public interface AidTypeRepository extends JpaRepository<AidType, Long>{

}