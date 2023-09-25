package com.moss.custom.model.orphanage;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.moss.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "orphanage_income_source_type")
public class OrphanageIncomeSourceType extends BaseEntity {

  private String type;

}
