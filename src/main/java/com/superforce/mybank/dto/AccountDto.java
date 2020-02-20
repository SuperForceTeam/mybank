package com.superforce.mybank.dto;

import com.superforce.mybank.common.MyBankEnum.AccountType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDto {

	private AccountType accountType;
	private Double salaryAmount;
	private Integer customerId;
}
