package com.springboot.crud.cruddemo.service;

import java.util.List;

import com.springboot.crud.cruddemo.entity.Employee;

public interface EmployeeService {
	
	
	public List<Employee> findAll();
	public void save(Employee employee);
	public void delete(int theId);
	public Employee findById(int theId);
 

}
