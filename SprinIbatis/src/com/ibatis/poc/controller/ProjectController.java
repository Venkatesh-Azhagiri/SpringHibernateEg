package com.ibatis.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private String path;
	
	
	public ProjectController(){
		path = "project/";
	}

}
