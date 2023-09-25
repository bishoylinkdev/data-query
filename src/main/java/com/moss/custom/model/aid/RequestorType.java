package com.moss.custom.model.aid;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.moss.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "requestor_type")
public class RequestorType extends BaseEntity {

  private String type;


}
