package com.superforce.mybank.service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.AccountCreationFailedException;

public interface CustomerService {

	public AccountCreateResponseDto createCustomerAccount(CustomerDto customerDto)
			throws AccountCreationFailedException;

}
