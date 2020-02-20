package com.superforce.mybank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.superforce.mybank.common.MyBankEnum.AccountType;
import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.AccountDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.entity.Customer;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Mock
	CustomerRepository customerRepository;

	@Mock
	AccountRegistery accountRegistery;

	Customer customer = new Customer();
	CustomerDto customerDto = new CustomerDto();
	AccountCreateResponseDto accountCreateResponseDto = new AccountCreateResponseDto();
	AccountDto accountDto = new AccountDto();

	@Before
	public void init() {
		customer.setCustomerId(1);

		customerDto.setAccountType(AccountType.SAVING);

		accountDto.setAccountType(AccountType.SAVING);

		accountCreateResponseDto.setAccountNumber(60001L);
	}
}
