package com.superforce.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superforce.mybank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
