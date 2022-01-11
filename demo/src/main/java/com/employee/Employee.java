package com.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffid", updatable = false)
    private int staffId;
    @Column(name = "account", length = 100, nullable = false)
    private String account;
    @Column(name = "fullname", length = 100, nullable = false)
    private String fullName;
    @Column(name = "ngach", length = 30, nullable = false)
    private String ngach;
    @Column(name = "status", length = 20, nullable = false)
    private String status;
    @Column(name = "nb_of_contracts", length = 100, nullable = false)
    private String nbOfContracts;
    @Column(name = "bac")
    private int bac;
    @Column(name = "current_contract_no")
    private String currentContractNo;
    @Column(name = "current_contract_date")
    private Date currentContractDate;
    @Column(name = "current_contract_expire")
    private Date currentContractExpire;
    @Column(name = "fulltime_start")
    private Date fulltimeStart;
    @Column(name = "trial_finish")
    private Date trialFinish;
    @Column(name = "current_income")
    private double currentIncome;
    @Column(name = "official_income")
    private double officialIncome;
    @Column(name = "intern_income")
    private double internIncome;
    @Column(name = "max_year_bonus")
    private double maxYearBonus;
    @Column(name = "join_date")
    private Date joinDate;
    @Column(name = "leave_date")
    private Date leaveDate;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "dept", length = 100)
    private String dept;
    @Column(name = "address", length = 100)
    private String address;
    private int deleted;

}
