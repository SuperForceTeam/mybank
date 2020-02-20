package com.superforce.mybank.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.entity.Customer;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.exception.CustomerAlreadyExistException;
import com.superforce.mybank.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRegistery accountRegistery;

	@Override
	public AccountCreateResponseDto createCustomerAccount(CustomerDto customerDto)
			throws CustomerAlreadyExistException, AccountCreationFailedException {
		log.info("create a new customer for customer account...");

		Customer createCustomer = new Customer();
		log.info("setting values to dto to customer entity...");
		BeanUtils.copyProperties(customerDto, createCustomer);

		log.info("save the customer entity values...");
		customerRepository.save(createCustomer);

		return accountRegistery.getServiceBean(customerDto.getAccountType().toString()).createAccount(customerDto);
	}

}
