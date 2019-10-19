package com.test.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.app.viewObject.EmployeeInfo;
import com.test.app.viewObject.Response;

public interface EmployeeService {
	
	 public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	    
		Response addEmployee(EmployeeInfo employeeInfo);
	
}
