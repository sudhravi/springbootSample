package com.bootexample.demo;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String exception) {
		super(exception);
	}

}