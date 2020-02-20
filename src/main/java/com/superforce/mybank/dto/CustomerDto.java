package com.superforce.mybank.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.superforce.mybank.common.MyBankEnum.AccountType;
import com.superforce.mybank.constant.AppConstant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

	@NotNull(message = AppConstant.NAME_SHOULD_BE_NOT_NULL)
	private String name;
	@NotNull(message = AppConstant.NAME_SHOULD_BE_NOT_NULL)
	@Email(message = AppConstant.INVALID_EMAIL)
	private String emailAddress;
	private String fatherName;
	private String address;
	private String panNumber;
	private AccountType accountType;
	private Long phoneNumber;
	private Double salaryAmount;
}
