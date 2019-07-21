package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// define a controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// define a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// define a new controller method to read data and 
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert to upper case
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hey! " + theName + "! You're so gorgeous!";
		
		// add message to the model
		model.addAttribute("message",result);
		
		// return via helloworld.jsp
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, Model model) {
		
		// convert to upper case
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hey! My friend " + theName + "! You're so gorgeous!";
		
		// add message to the model
		model.addAttribute("message",result);
		
		// return via helloworld.jsp
		return "helloworld";
	}

}
