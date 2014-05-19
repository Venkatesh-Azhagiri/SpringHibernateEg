package com.spring.autowireConcept;

import org.springframework.beans.factory.annotation.Autowired;

public class Country {
	@Autowired
	Capital capital;
	
	public String countryName;

	public Capital getCapital() {
		return capital;
	}
	
	
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
	
	/*public Country(String countryName, Capital capital) {
		super();		
		this.countryName = countryName;
		this.capital = capital;
	}
*/

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
