package com.luv2code.springdemo.mvc;

import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
//	@Value("#{programmingLanguageList}")
//	private Map<String, String> programmingLanguageList;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		// add the country options to the model
		theModel.addAttribute("countryOptions", countryOptions);
		
//		// add the programming languages to the model
//		theModel.addAttribute("programmingLanguageList", programmingLanguageList);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult) {
		
		System.out.println("Binding Result : " + theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "student-form";
		}
		else {
			System.out.println("theStudent First Name    : " + theStudent.getFirstName());
			System.out.println("theStudent Last  Name    : " + theStudent.getLastName());
			System.out.println("theStudent Country       : " + theStudent.getCountry());
			System.out.println("theStudent Course Code   : " + theStudent.getCourseCode());
//			System.out.println("theStudent Favorite Lang : " + theStudent.getFavoriteLanguage());
			System.out.println("theStudent Operating Sys : " + Arrays.toString(theStudent.getOperatingSystems()));
			return "student-confirmation";
		}
	}
}
