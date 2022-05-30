package com.springboot.crud.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.cruddemo.dao.EmployeeDAO;
import com.springboot.crud.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
	
		employeeDao.save(employee);
		
	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		employeeDao.deleteById(theId);
	
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
	
		return employeeDao.findById(theId);
	}
	
	
	
	

}
