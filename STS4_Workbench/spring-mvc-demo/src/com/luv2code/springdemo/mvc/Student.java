package com.luv2code.springdemo.mvc;

import java.util.List;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	@CourseCode
	private String courseCode;
	
	private List<List<String>> countryList;
	
//	private String favoriteLanguage;
//	
//	private List<List<String>> programmingLanguageList;
//	
	private String[] operatingSystems;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<List<String>> getCountryList() {
		return countryList;
	}
	
	public void setCountryList(List<List<String>> countryList) {
		this.countryList = countryList;
	}

//	public String getFavoriteLanguage() {
//		return favoriteLanguage;
//	}
//
//	public void setFavoriteLanguage(String favoriteLanguage) {
//		this.favoriteLanguage = favoriteLanguage;
//	}
//
//	public List<List<String>> getProgrammingLanguageList() {
//		return programmingLanguageList;
//	}
//
//	public void setProgrammingLanguageList(List<List<String>> programmingLanguageList) {
//		this.programmingLanguageList = programmingLanguageList;
//	}
//
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
