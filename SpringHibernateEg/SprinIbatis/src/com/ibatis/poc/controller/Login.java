package com.ibatis.poc.controller;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibatis.poc.user.daoImplementation.UserDAOImplementation;
import com.ibatis.poc.user.model.UserModel;

@Controller
@RequestMapping("/*")
public class Login {
	private String path;
	@Autowired
	public UserDAOImplementation userImplementation;
	public UserModel userModel;

	public Login() {		
		path = "/";
	}
	
	@RequestMapping(value ="index.do", method=RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv =  new ModelAndView(path  + "index");
		/*List<UserModel> model = userImplementation.listUsers();
		System.out.println("MODLfE***"+model.size());
		for(UserModel md: model){
			System.out.println("user***"+md.getUserName());
		}*/
		/*Iterator<UserModel> it = model.iterator();
		while(it.hasNext()){
			System.out.println("itere***"+it.next().getUserName());
		}
		System.out.println("ni****"+model);
		for(int i=0; i< model.size(); ++i){
			UserModel u = model.get(i);
			System.out.println("user name***"+u.getUserName());
		}*/
	   /*UserModel userValidate =  userImplementation.getValidUser("");
	   System.out.println("from ibatis***"+userValidate.getUserName()+"**** password***"+userValidate.getPassword());*/
		
		
		// Mar 24 2013 
		/*System.out.println("in login action is");
		List<UserModel> userValidate =  userImplementation.getListUser("");
		   for(UserModel modelList:userValidate){
			   System.out.println("User ID****"+modelList.getUserId());
		  	}*/
		return mv;
	}
	
	@RequestMapping(value ="index.do", method =RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute("userModel") UserModel userModel, HttpServletRequest request,
			HttpServletResponse response){
	ModelAndView mv;
	System.out.println("post method***");
	int validateCount = userImplementation.getValidUser(userModel);
	System.out.println("validateCount***"+validateCount);	
	if(validateCount <= 0){		
		System.out.println("failed****");
		mv = new ModelAndView(path + "index");
		mv.addObject("status", "failed");
	} else {
		mv = new ModelAndView("redirect:project/index.do");
	}
	return mv;
	}
	

}
