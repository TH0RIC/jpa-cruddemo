package com.springboot.crud.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager theEntityManager) {
		
		 entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		
		// get the current hibernate session
		Session currentSession= entityManager.unwrap(Session.class);
		
		
		// create a query
		
		Query<Employee> theQuery=
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees=theQuery.getResultList();
		
		// return results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee theEmployee =
				currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		// save the employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		Query query= currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
