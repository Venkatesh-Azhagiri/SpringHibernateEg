package com.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.entity.Employee;
import com.user.model.UserModel;

public class UserService {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
	    return sessionFactory.getCurrentSession();
	}
	
	public List<Employee> getListOfEmployees(){
		List<Employee> employeeList = new ArrayList<Employee>();
		return employeeList;
	}

	public void createSession(HttpServletRequest request, UserModel userModel) {
		HttpSession session = request.getSession();
		session.setAttribute("user", userModel.getUserId());
	}
	
	public boolean login(HttpServletRequest request, UserModel userModel) {
		// TODO Auto-generated method stub
		System.out.println("test login");
		/*Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction()*/
		//List<UserModel> userList = sessionFactory.openSession().createQuery("from UserModel").list();
		Query q = sessionFactory.openSession().createQuery("from UserModel where userId=? and password= ?");
		q.setParameter(0, userModel.getUserId());
		q.setParameter(1, userModel.getPassword());
		List<UserModel> userList = q.list();
		for(UserModel model: userList){
			System.out.println("model username****"+model.getUserId());
			return true;
		}
		return false;
	}

}
