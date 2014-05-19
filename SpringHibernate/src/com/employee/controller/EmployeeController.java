package com.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.details.entity.EmployeeDetail;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee/*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	private String path = "employee/";
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public ModelAndView getEmployeeList(HttpServletRequest request, HttpSession session){
		//System.out.println("employee controller****");
		ModelAndView mv = new ModelAndView(path +"index");
		mv.addObject("employeeList",employeeService.getEmployeeList());
		mv.addObject("context", "employee");
		return mv;
	}
	
	@RequestMapping(value = "add_employee.do", method = RequestMethod.GET)
	public ModelAndView getAddEmployee(HttpServletRequest request, HttpSession session){
		ModelAndView mv = new ModelAndView(path + "addEmployee");
		return mv;
	}
	
	@RequestMapping(value = "add_employee.do", method = RequestMethod.POST)
	public ModelAndView postEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("employeeDetail") EmployeeDetail employeeDetail, HttpServletRequest request, HttpSession session){
		System.out.println("first name**"+employee.getFirstName());
		System.out.println("Last name****"+employee.getLastName());
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		employeeService.addEmployee(employee);
		System.out.println("modified private street****"+employee.getEmployeeDetail().getStreet());
		return new ModelAndView("redirect:index.do");
	}
	
	@RequestMapping(value = "edit_employee.do", method = RequestMethod.GET)
	public ModelAndView getEditEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request, HttpSession session){
		ModelAndView mv = new ModelAndView(path + "editEmployee");
		mv.addObject("employee", employeeService.getEmployeeDetails(employee));
		return mv;
	}
	
	
	@RequestMapping(value = "edit_employee.do", method = RequestMethod.POST)
	public ModelAndView postEditEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("employeeDetail") EmployeeDetail employeeDetail, HttpServletRequest request, HttpSession session){
		System.out.println("first name**"+employee.getFirstName());
		System.out.println("Last name****"+employee.getLastName());
		employee.setEmployeeDetail(employeeDetail);
		employee.setLastName("Azhagiri");
		employeeDetail.setEmployee(employee);
		employeeService.editEmployee(employee);
		System.out.println("modified private street****"+employee.getEmployeeDetail().getStreet());
		return new ModelAndView("redirect:index.do");
	}
}
