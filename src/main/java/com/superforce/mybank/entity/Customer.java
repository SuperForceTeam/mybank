package com.superforce.mybank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.superforce.mybank.common.MyBankEnum.AccountType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Govindasamy.C
 * @since 20-02-2020
 * @version V1.1
 *
 */
@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String emailAddress;
	private String fatherName;
	private String address;
	private String panNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private Long phoneNumber;
	private Double salaryAmount;
}
