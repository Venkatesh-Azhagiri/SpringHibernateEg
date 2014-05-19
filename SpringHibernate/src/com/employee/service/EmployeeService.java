package com.employee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.entity.Employee;

public class EmployeeService {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
	    return sessionFactory.getCurrentSession();
	}
	

	public List<Employee> getEmployeeList() {
		List<Employee> employeeList  = sessionFactory.openSession().createQuery("From Employee").list();
		return employeeList;
	}


	public void addEmployee(Employee employee) {
		System.out.println("test*********");
		sessionFactory.openSession().save(employee);
		
	}


	public Employee getEmployeeDetails(Employee employee) {
		Employee employeeModel = (Employee)sessionFactory.openSession().get(Employee.class, employee.getEmployeeId());
		return employeeModel;
	}


	public void editEmployee(Employee employee) {
		System.out.println("test*****"+employee.getLastName());
		Employee employeeModel = (Employee)sessionFactory.openSession().get(Employee.class, employee.getEmployeeId());		
		sessionFactory.openSession().update(employeeModel);
		
		// TODO Auto-generated method stub
		
	}

}
