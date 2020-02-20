package com.superforce.mybank.dto;

import lombok.Data;

@Data
public class AccountCreateResponseDto {
	
	private Long accountNumber;
	private Integer statusCode;
	private String message;

}
