package com.superforce.mybank.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccountCreateRequestDto {

	@NotNull
	private Long userId;
	@NotNull
	private String fatherName;
	@NotNull
	private String motherName;
	@NotNull
	private String address;
	@NotNull
	private String panNumber;
	@NotNull
	private String accountType;
	@NotNull
	private String nationality;
	@NotNull
	private LocalDate dateOfBirth;
	@NotNull
	private String email;
	@NotNull
	private Double salary;
	@NotNull
	private Double mortgageAmount;
	
	

}
