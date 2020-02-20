package com.superforce.mybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superforce.mybank.common.MyBankEnum.AccountType;
import com.superforce.mybank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByPhoneNumberAndAccountType(Long phoneNumber, AccountType accountType);
}
