package com.superforce.mybank.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.superforce.mybank.common.MyBankEnum.AccountType;

import lombok.Data;

@Data
@SequenceGenerator(name = "accountNumber", initialValue = 60000056, allocationSize = 1)
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumber")
	private Long accountNumber;
	private Long userId;
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
}
