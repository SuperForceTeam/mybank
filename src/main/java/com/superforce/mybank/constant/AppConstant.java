package com.superforce.mybank.constant;

public class AppConstant {

	private AppConstant() {

	}

	// Customer
	public static final String NAME_SHOULD_BE_NOT_NULL = "Name should not be null";
	public static final String EMAIL_SHOULD_BE_NOT_NULL = "Email Address should not be null";
	public static final String PAN_NUMBER_SHOULD_BE_NOT_NULL = "Pan Number should not be null";

	public static final String INVALID_EMAIL = "Invalid Email Address";

	public static final String CUSTOMER_ACCOUNT_CREATED_SUCCESSFULLY = "Customer Account Created Successfully.";
	public static final String CUSTOMER_ALREADY_EXISTS = "Customer Already Exist.";

	// account messages
	public static final String MORTGAGE_ACCOUNT_CREATED = "Mortage account created";
	public static final String SAVINGS_ACCOUNT_CREATED = "Savings account created";
	public static final String MORTGAGE_ACCOUNT = "MORTGAGE";
	public static final String SAVINGS_ACCOUNT = "SAVING";

	public static final String MORTGAGE_ACCOUNT_SALARY_FAIL = "Salary is less than expected for loan";

	// account codes	
	public static final String CUSTOMER_ALREADY_EXIST = "SF-201";
	public static final String MORTGAGE_ACCOUNT_FAIL_CODE = "SF-051";
	public static final String SAVINGS_ACCOUNT_FAIL_CODE = "SF-151";
	public static final String MORTGAGE_ACCOUNT_SUCCESS_CODE = "SF-001";
	public static final String SAVINGS_ACCOUNT_SUCCESS_CODE = "SF-101";

}
