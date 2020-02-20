package com.superforce.mybank.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.superforce.mybank.constant.AppConstant;
import com.superforce.mybank.dto.ResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle the not valid field errors along with validation messages and get the
	 * list of multiple field errors.
	 * 
	 * @author Govindasamy.C
	 * @since 20-02-2020
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("date", LocalDateTime.now());
		body.put("status", status.value());

		// Get all errors for field valid
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());

		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

	@ExceptionHandler(AccountCreationFailedException.class)
	public ResponseDto mortgageAccountCreationFailedException(AccountCreationFailedException e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(AppConstant.MORTGAGE_ACCOUNT_FAIL_CODE);
		return responseDto;
	}

	@ExceptionHandler(CustomerAlreadyExistException.class)
	public ResponseDto customerAlreadyExistException(CustomerAlreadyExistException e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(AppConstant.CUSTOMER_ALREADY_EXIST);
		return responseDto;
	}

}
