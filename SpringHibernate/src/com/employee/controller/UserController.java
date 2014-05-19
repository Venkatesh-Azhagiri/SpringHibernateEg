package com.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.model.UserModel;
import com.user.service.UserService;

@Controller
@RequestMapping("/*")
public class UserController {
	@Autowired
	private UserService userService;
	private String path = "employee/";
	
	@RequestMapping(value = "index.do", method =RequestMethod.GET)
	public ModelAndView getLoginPage(@ModelAttribute("userModel") UserModel userModel){
		ModelAndView mv = new ModelAndView("index");
		//System.out.println("test login controller*****");
		return mv;
	}
	
	
	@RequestMapping(value = "index.do", method =RequestMethod.POST)
	public ModelAndView postLoginPage(@ModelAttribute("userModel") UserModel userModel, HttpServletRequest request){
		/*ModelAndView mv = new ModelAndView(path+"index");
		System.out.println("userId****"+userModel.getUserId());
		System.out.println("password****"+userModel.getPassword());*/
		
		boolean isValidLogin = userService.login(request, userModel);
		if(isValidLogin){
			userService.createSession(request, userModel);
			return new ModelAndView("redirect:employee/index.do");
		}else{
			return new ModelAndView("redirect:index.do");
		}
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public ModelAndView logoutSeesion (@ModelAttribute("user")UserModel user, HttpServletRequest request, HttpSession session) {
		String reqURL = request.getRequestURL().toString();
		session.invalidate();
		reqURL = reqURL.replace("logout.do","");
		return new ModelAndView("redirect:index.do");
	}
	
}
