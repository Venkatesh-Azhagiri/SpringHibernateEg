package com.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.base.model.UserModel;
import com.employee.bean.EmployeeBean;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@Controller
public class UserController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserModel userModel;
@RequestMapping(value ="/index.do", method = RequestMethod.GET)
public ModelAndView indexLoginPage(){
	ModelAndView mv = new ModelAndView("index");
	System.out.println("test controller");
	return mv;
}
@RequestMapping(value ="/index.do", method = RequestMethod.POST)
public ModelAndView PostLoginPage(HttpServletRequest request){
	HttpSession session = request.getSession();
	Map<String, Object> model = new HashMap<String, Object>();
	session.setAttribute("user", "venkatesh");
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("employeesList", model);
}

/*@RequestMapping(value="/employees", method = RequestMethod.GET)
public ModelAndView listEmployees() {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("employeesList", model);
}
*/
private List<EmployeeBean> prepareListofBean(List<Employee> employees){
	List<EmployeeBean> beans = null;
	if(employees != null && !employees.isEmpty()){
		beans = new ArrayList<EmployeeBean>();
		EmployeeBean bean = null;
		userModel.setUserId("");
		for(Employee employee : employees){
			bean = new EmployeeBean();
			bean.setName(employee.getEmpName());
			bean.setId(employee.getEmpId());
			bean.setAddress(employee.getEmpAddress());
			bean.setSalary(employee.getSalary());
			bean.setAge(employee.getEmpAge());
			beans.add(bean);
		}
	}
	return beans;
}
@RequestMapping(value = "/add.do", method = RequestMethod.GET)
public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
		BindingResult result) {
	System.out.println("ad controller");
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("addEmployee", model);
}
@RequestMapping(value = "/save.do", method = RequestMethod.POST)
public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, 
		BindingResult result) {
	Employee employee = prepareModel(employeeBean);
	employeeService.addEmployee(employee);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("employeesList", model);
	//return new ModelAndView("redirect:/add.html");
}
@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("addEmployee", model);
}
@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
		BindingResult result) {
	employeeService.deleteEmployee(prepareModel(employeeBean));
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("employee", null);
	model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
	return new ModelAndView("addEmployee", model);
}
private EmployeeBean prepareEmployeeBean(Employee employee){
	EmployeeBean bean = new EmployeeBean();
	bean.setAddress(employee.getEmpAddress());
	bean.setAge(employee.getEmpAge());
	bean.setName(employee.getEmpName());
	bean.setSalary(employee.getSalary());
	bean.setId(employee.getEmpId());
	return bean;
}
private Employee prepareModel(EmployeeBean employeeBean){
	Employee employee = new Employee();
	employee.setEmpAddress(employeeBean.getAddress());
	employee.setEmpAge(employeeBean.getAge());
	employee.setEmpName(employeeBean.getName());
	employee.setSalary(employeeBean.getSalary());
	employee.setEmpId(employeeBean.getId());
	employeeBean.setId(null);
	return employee;
}
}
