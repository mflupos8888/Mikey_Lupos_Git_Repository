package com.luv2code.springdemo.mvc;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@Value("#{programmingLanguageList}")
	private Map<String, String> programmingLanguageList;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		// add the country options to the model
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		// add the programming languages to the model
		theModel.addAttribute("theProgrammingLanguageList", programmingLanguageList);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("theStudent First Name    : " + theStudent.getFirstName());
		System.out.println("theStudent Last  Name    : " + theStudent.getLastName());
		System.out.println("theStudent Country       : " + theStudent.getCountry());
		System.out.println("theStudent Favorite Lang : " + theStudent.getFavoriteLanguage());
		System.out.println("theStudent Operating Sys : " + Arrays.toString(theStudent.getOperatingSystems()));

		return "student-confirmation";
	}
}
