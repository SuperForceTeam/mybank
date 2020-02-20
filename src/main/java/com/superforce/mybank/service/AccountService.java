package com.superforce.mybank.service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.AccountDto;
import com.superforce.mybank.exception.AccountCreationFailedException;

public interface AccountService {

	public AccountCreateResponseDto createAccount(AccountDto accountDto)
			throws AccountCreationFailedException;

}
