package com.superforce.mybank.service;

import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.CustomerAlreadyExistException;

public interface CustomerService {

	public void createCustomerAccount(CustomerDto customerDto) throws CustomerAlreadyExistException;

}
