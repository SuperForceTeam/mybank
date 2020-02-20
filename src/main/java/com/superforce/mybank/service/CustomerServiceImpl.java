package com.superforce.mybank.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superforce.mybank.constant.AppConstant;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.entity.Customer;
import com.superforce.mybank.exception.CustomerAlreadyExistException;
import com.superforce.mybank.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void createCustomerAccount(CustomerDto customerDto) throws CustomerAlreadyExistException {
		log.info("create a new customer for customer account...");
		// Find customer details is already exists or not.
		Optional<Customer> customer = customerRepository.findByPhoneNumber(customerDto.getPhoneNumber());
		if (customer.isPresent()) {
			throw new CustomerAlreadyExistException(AppConstant.CUSTOMER_ALREADY_EXISTS);
		}

		Customer createCustomer = new Customer();
		log.info("setting values to dto to customer entity...");
		BeanUtils.copyProperties(customerDto, createCustomer);
		
		log.info("save the customer entity values...");
		customerRepository.save(createCustomer);
	}

}
