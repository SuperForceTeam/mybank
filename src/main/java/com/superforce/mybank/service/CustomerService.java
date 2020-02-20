package com.superforce.mybank.service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.exception.CustomerAlreadyExistException;

public interface CustomerService {

	public AccountCreateResponseDto createCustomerAccount(CustomerDto customerDto)
			throws CustomerAlreadyExistException, AccountCreationFailedException;

}
