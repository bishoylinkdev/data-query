package com.moss.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.custom.model.aid.RequestorType;

@Repository
public interface RequestorTypeRepository extends JpaRepository<RequestorType, Long>{

}
