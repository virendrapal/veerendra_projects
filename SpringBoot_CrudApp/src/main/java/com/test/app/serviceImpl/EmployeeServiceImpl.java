package com.test.app.serviceImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.Repository.EmployeeRepository;
import com.test.app.constant.Constant;
import com.test.app.entity.Employee;
import com.test.app.exception.InputInfoException;
import com.test.app.service.EmployeeService;
import com.test.app.viewObject.EmployeeInfo;
import com.test.app.viewObject.Response;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Response addEmployee(EmployeeInfo employeeInfo){
		
		Response response = new Response();
		int action = employeeInfo.getAction();
		Employee employee=null;
		switch (action) {
		case Constant.ONE:
			logger.info("Inserting data of employee:"+employeeInfo.toString());
			if(employeeInfo.getAction()!=0  &&
					employeeInfo.getEmail()!=null && employeeInfo.getFirstName()!=null && employeeInfo.getLastName()
					!=null){
				Optional<Employee> emp= employeeRepository.findTopByEmail(employeeInfo.getEmail());
				if(!emp.isPresent()){
					employee = new Employee();
					employee.setFirstName(employeeInfo.getFirstName());
					employee.setLastName(employeeInfo.getLastName());
					employee.setAddress(employeeInfo.getAddress());
					employee.setMobileNo(employeeInfo.getMobileNo());
					employee.setEmail(employeeInfo.getEmail());
					employee.setCreatedDate(new Date());
					if(employeeInfo.getCreatedBy()==null)
				    employee.setCreatedBy(Constant.CREATED_BY);
					else
					employee.setCreatedBy(employeeInfo.getCreatedBy());
					
					employeeRepository.save(employee);
					
					response.setStatusCode(Constant.SUCCESS);
					response.setStatusDesc(Constant.STATUS_DESC);
					response.setResponseObj(employee);
				}else{
					response.setStatusCode(Constant.FAIL);
					response.setStatusDesc(Constant.EXIST);
				}
			}else{
				throw new InputInfoException(Constant.INPUT_EXCEPTION);
			}
			break;
		case Constant.TWO:
			logger.info("retriving data of employee:"+employeeInfo);
			if(employeeInfo.getId()!=0){
				Optional<Employee> employee2 = employeeRepository.findListById(employeeInfo.getId());
				if(employee2.isPresent()){
					response.setResponseObj(employee2);
					response.setStatusCode(Constant.SUCCESS);
					response.setStatusDesc(Constant.STATUS_DESC);
				}else{
					response.setStatusCode(Constant.FAIL);
					response.setStatusDesc(Constant.NOT_EXIST);
				}
			}else{
				throw new InputInfoException(Constant.INPUT_EXCEPTION);
			}
			break;
		case Constant.THREE:
			logger.info("dleteing data of employee:"+employeeInfo);
			if(employeeInfo.getId()!=0){
				employeeRepository.deleteById(employeeInfo.getId());
				response.setStatusCode(Constant.SUCCESS);
				response.setStatusDesc(Constant.STATUS_DESC);
			}else{
				throw new InputInfoException(Constant.INPUT_EXCEPTION);	
			}
			break;
		case Constant.FOUR:
			logger.info("updating data of employee:"+employeeInfo);
			if(employeeInfo.getId()!=0){
				Optional<Employee> emp = employeeRepository.findById(employeeInfo.getId());
				if(emp.isPresent()){
					Employee employee2 = new Employee();
					employee2.setFirstName(employeeInfo.getFirstName());
					employee2.setLastName(employeeInfo.getLastName());
					employee2.setEmail(employeeInfo.getEmail());
					employee2.setMobileNo(employeeInfo.getMobileNo());
					employee2.setAddress(employeeInfo.getAddress());
					employee2.setCreatedDate(new Date());
					if(employeeInfo.getCreatedBy()==null)
					employee2.setCreatedBy(Constant.CREATED_BY);
					else{
						employee2.setCreatedBy(employeeInfo.getCreatedBy());
					}
					employeeRepository.save(employee2);
					response.setStatusCode(Constant.SUCCESS);
					response.setStatusDesc(Constant.STATUS_DESC);
					response.setResponseObj(employee2);
				}else{
					throw new InputInfoException(Constant.EXIST);	
				}
			}else{
				throw new InputInfoException(Constant.INPUT_EXCEPTION);		
			}
			break;
		default:
			break;
		}
	return response;
}

}
