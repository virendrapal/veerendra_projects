package com.test.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

	Optional<Employee> findListById(int id);
	
	Optional<Employee> findTopByEmail(String email);
	
	Optional<Employee> findById(int id);
	
 }
