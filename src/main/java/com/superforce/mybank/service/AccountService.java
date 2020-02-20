package com.superforce.mybank.service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.AccountCreationFailedException;

public interface AccountService {

	public AccountCreateResponseDto createAccount(CustomerDto customerDto)
			throws AccountCreationFailedException;

}
