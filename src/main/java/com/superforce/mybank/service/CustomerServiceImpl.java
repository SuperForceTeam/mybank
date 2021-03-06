package com.superforce.mybank.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.AccountDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.entity.Customer;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Customer Service Impl Class - we can handle the customer functionalities of
 * creating a customer and pass the values to customer account creation services.
 * 
 * @author Govindasamy.C
 * @since 20-02-2020
 * @version V1.1
 *
 */
@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRegistery accountRegistery;

	/**
	 * 
	 * @param customerDto - details of the customer details with account details of
	 *                    type.
	 * @return details of the response details of status code and message.
	 * @author Govindasamy.C
	 * @throws CustomerAlreadyExistException - if customer details is already exists
	 *                                       in the application throws this
	 *                                       exception.
	 * @since 20-02-2020
	 */
	
	@Override
	public AccountCreateResponseDto createCustomerAccount(CustomerDto customerDto)
			throws AccountCreationFailedException {
		log.info("create a new customer for customer account...");

		Customer createCustomer = new Customer();
		log.info("setting values to dto to customer entity...");
		BeanUtils.copyProperties(customerDto, createCustomer);

		log.info("save the customer entity values...");
		customerRepository.save(createCustomer);

		AccountDto accountDto = new AccountDto();
		BeanUtils.copyProperties(createCustomer, accountDto);
		accountDto.setCustomerId(createCustomer.getCustomerId());
		return accountRegistery.getServiceBean(customerDto.getAccountType().toString()).createAccount(accountDto);
	}

}
