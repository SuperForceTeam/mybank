package com.superforce.mybank;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.superforce.mybank.service.AccountRegistery;

@SpringBootApplication
public class MyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBankApplication.class, args);
	}
	
	@Bean
	public FactoryBean<?> getBean(){
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(AccountRegistery.class);
		return bean;
	}

}
