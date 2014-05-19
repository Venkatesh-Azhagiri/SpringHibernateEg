package com.spring.autowireConcept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//http://javapostsforlearning.blogspot.in/2012/09/autowired-annotation-in-spring.html
public class Root {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("venkatesh.xml");
		Country countryObj = (Country)context.getBean("countryBean");
		String countryName = countryObj.getCountryName();
		Capital capital = countryObj.getCapital();
		String capitalName = capital.getCapitalName();
		System.out.println(countryName + " country capital "+capitalName);

	}

}
