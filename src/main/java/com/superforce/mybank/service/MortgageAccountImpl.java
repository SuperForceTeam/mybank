package com.superforce.mybank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superforce.mybank.constant.AppConstant;
import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.CustomerDto;
import com.superforce.mybank.entity.Account;
import com.superforce.mybank.exception.AccountCreationFailedException;
import com.superforce.mybank.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service(AppConstant.MORTGAGE_ACCOUNT)
@Slf4j
public class MortgageAccountImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	/**
	 * 
	 * this method takes the responsibity for Mortgage account creation.
	 * 
	 * @param accountCreateRequestDto which contains customer details like
	 *                                customerId, name accountType, date of birth,
	 *                                address.
	 * @return accountCreateRequestDto contains accountNumber, statusCode and
	 *         Message.
	 * @throws AccountCreationFailedException
	 */
	@Override
	public AccountCreateResponseDto createAccount(CustomerDto customerDto)
			throws AccountCreationFailedException {
		log.info("MortgageAccountImpl createAccount ----> creating Mortgage Account");
		if (customerDto.getSalaryAmount() < 10000) {
			log.error("MortgageAccountImpl createAccount ----> AccountCreationFailedException : "
					+ AppConstant.MORTGAGE_ACCOUNT_SALARY_FAIL);
			throw new AccountCreationFailedException(AppConstant.MORTGAGE_ACCOUNT_SALARY_FAIL);
		}
		Account account = new Account();
		Double mortgageAmount = customerDto.getSalaryAmount() *3;
		account.setBalance(-mortgageAmount);
		account.setAccountType(customerDto.getAccountType());
		account = accountRepository.save(account);
		log.info("MortgageAccountImpl createAccount ----> Mortgage Account created");
		AccountCreateResponseDto accountCreateResponseDto = new AccountCreateResponseDto();
		accountCreateResponseDto.setMessage(AppConstant.MORTGAGE_ACCOUNT_CREATED);
		accountCreateResponseDto.setAccountNumber(account.getAccountNumber());
		return accountCreateResponseDto;
	}

}
