package com.superforce.mybank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superforce.mybank.constant.AppConstant;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.dto.ResponseDto;
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
	 * @since 20-02-2020
	 */
	@PostMapping
	public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
		log.info("create a new customer for customer account...");
		customerService.createCustomerAccount(customerDto);
		ResponseDto responseDto = new ResponseDto();
		log.info("setting the response values in customer account creation...");
		responseDto.setMessage(AppConstant.CUSTOMER_CREATED_SUCCESSFULLY);
		responseDto.setStatusCode(HttpStatus.CREATED.value());
		log.info("return the response values in customer account creation...");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
