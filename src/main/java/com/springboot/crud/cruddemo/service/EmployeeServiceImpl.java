package com.springboot.crud.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.cruddemo.dao.EmployeeRepository;
import com.springboot.crud.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
	
		employeeRepository.save(employee);
		
	}

	@Override
	public void delete(int theId) {
		
		employeeRepository.deleteById(theId);
	
	}

	@Override
	public Employee findById(int theId) {
		
		
		// Optional : Java8 new feature instead of checking for nulls
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			
			theEmployee=result.get();
			
		}else {
			
			throw new RuntimeException("Did not find employee id -"+theId);
			
		}
		
		
		return theEmployee;
	}
	
	
	
	

}
