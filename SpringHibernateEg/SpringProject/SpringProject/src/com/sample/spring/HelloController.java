package com.sample.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/")
	  public String hello() 
		{
		System.out.println("INITIAL FGG*****");
	    	return "hello";
		}
	 
	  @RequestMapping(value = "/hi", method = RequestMethod.GET)
	  public String hi(@RequestParam("name") String name, Model model) 
	  {
	    String message = "Hi " + name + "!";
	    System.out.println("test***"+message);
	    model.addAttribute("message", message);
	    return "hi";
	  }
}
