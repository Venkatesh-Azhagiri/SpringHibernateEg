package com.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;

public class Triangle implements Shape {
	@Autowired
	public Circle circle;
	public void draw(){
		System.out.println("Triangle Drawn");
	}

}
