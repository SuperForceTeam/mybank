package com.superforce.mybank.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.exception.CustomerAlreadyExistException;
import com.superforce.mybank.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;

	CustomerDto customerDto = new CustomerDto();
	AccountCreateResponseDto accountCreateResponseDto = new AccountCreateResponseDto();

	@Before
	public void init() {
		customerDto.setPhoneNumber(8675958381L);

		accountCreateResponseDto.setAccountNumber(60001L);
	}

	@Test
	public void testCreateCustomerAccount() throws CustomerAlreadyExistException, AccountCreationFailedException {
		when(customerService.createCustomerAccount(customerDto)).thenReturn(accountCreateResponseDto);
		ResponseEntity<AccountCreateResponseDto> response = customerController.createCustomerAccount(customerDto);
		assertEquals(201, response.getBody().getStatusCode());
	}
}
