package com.springboot.crud.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
