package com.moss.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.custom.model.common.Administration;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Long>{

}
