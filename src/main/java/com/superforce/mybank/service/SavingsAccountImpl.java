package com.superforce.mybank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superforce.mybank.constant.AppConstant;
import com.superforce.mybank.dto.AccountCreateResponseDto;
import com.superforce.mybank.dto.AccountDto;
import com.superforce.mybank.entity.Account;
import com.superforce.mybank.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service(AppConstant.SAVINGS_ACCOUNT)
@Slf4j
public class SavingsAccountImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	/**
	 * 
	 * this method takes the responsibity for Savings account creation.
	 * 
	 * @param accountCreateRequestDto which contains customer details like
	 *                                customerId, name accountType, date of birth,
	 *                                address.
	 * @return accountCreateRequestDto contains accountNumber, statusCode and
	 *         Message.
	 */
	@Override
	public AccountCreateResponseDto createAccount(AccountDto accountDto) {
		log.info("SavingsAccountImpl createAccount ----> creating Savings Account");
		AccountCreateResponseDto accountCreateResponseDto = new AccountCreateResponseDto();
		Account account = new Account();
		account.setBalance(1000);
		account.setAccountType(accountDto.getAccountType());
		account.setUserId(accountDto.getCustomerId());
		account = accountRepository.save(account);
		log.info("MortgageAccountImpl createAccount ----> Mortgage Account created");
		accountCreateResponseDto.setMessage(AppConstant.SAVINGS_ACCOUNT_CREATED);
		accountCreateResponseDto.setAccountNumber(account.getAccountNumber());
		return accountCreateResponseDto;
	}

}
