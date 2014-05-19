package com.spring.dependency.injection;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Shape shape = new Circle();
		//shape.draw(); 
		Drawing drawingClass = new Drawing(shape);
		drawingClass.drawTheShape();*/
		ApplicationContext context  = new ClassPathXmlApplicationContext("venkatesh.xml");
		Triangle trgle = (Triangle)context.getBean("triangle");
		Circle  cr = (Circle)context.getBean("circle");
		trgle.draw();
		cr.draw();
				
	}

}
