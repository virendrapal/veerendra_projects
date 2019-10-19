package com.test.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.constant.Constant;
import com.test.app.service.EmployeeService;
import com.test.app.viewObject.EmployeeInfo;
import com.test.app.viewObject.Response;

@Component
@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeAddService;
	

	@PostMapping(Constant.MANAGE_EMPLOYEE)
	public Response addEmployee(@RequestBody EmployeeInfo employeeInfo){
		logger.info("Employee controller:"+employeeInfo);
		return employeeAddService.addEmployee(employeeInfo);
	}
}
