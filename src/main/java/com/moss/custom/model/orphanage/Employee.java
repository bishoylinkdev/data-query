package com.moss.custom.model.orphanage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    private String firstName;

    private String secondName;

    private String thirdName;

    private String lastName;

    private String nationality;

    private Integer permissionNumber;

    private Date birthday;

    private String qualification;

    private String qualificationType;

    private Integer qualificationYear;

    private String mobileNumber;

    private String jobTitle;

    private Integer employmentYear;

    private String contractType;

    private String salary;

    private String criminalRecordsCertificate;

    private String employerStatus;

    private Date dismissalDate;

    private String dismissalReasons;

    private String actionTaken;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

}
