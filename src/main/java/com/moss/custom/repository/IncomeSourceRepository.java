package com.moss.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.custom.model.orphanage.OrphanageIncomeSourceType;

@Repository
public interface IncomeSourceRepository extends JpaRepository<OrphanageIncomeSourceType, Long>{

}
