package com.superforce.mybank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.exception.CustomerAlreadyExistException;
import com.superforce.mybank.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * Customer Controller Class - we can handle the customer functionalities of
 * creating a customer and pass the values to customer creation services.
 * 
 * @author Govindasamy.C
 * @since 20-02-2020
 * @version V1.1
 *
 */
@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * 
	 * @param customerDto - details of the customer details with account details of
	 *                    type.
	 * @return details of the response details of status code and message.
	 * @author Govindasamy.C
	 * @throws CustomerAlreadyExistException  - if customer details is already
	 *                                        exists in the application throws this
	 *                                        exception.
	 * @throws AccountCreationFailedException
	 * @since 20-02-2020
	 */
	@PostMapping
	public ResponseEntity<AccountCreateResponseDto> createCustomerAccount(@Valid @RequestBody CustomerDto customerDto)
			throws AccountCreationFailedException {
		log.info("create a new customer for customer account...");
		AccountCreateResponseDto accountCreateResponseDto = customerService.createCustomerAccount(customerDto);
		log.info("setting the response values in customer account creation...");
		accountCreateResponseDto.setStatusCode(HttpStatus.CREATED.value());
		log.info("return the response values in customer account creation...");
		return new ResponseEntity<>(accountCreateResponseDto, HttpStatus.OK);
	}

}
