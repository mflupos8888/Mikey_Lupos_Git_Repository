package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		System.out.println("CourseCodeConstraintValidator : initialize " + theCourseCode);
		setCoursePrefix(theCourseCode.value());
		System.out.println("CourseCodeConstraintValidator : coursePrefix " + coursePrefix);
	}
	
	@Override
	public boolean isValid(String theCourseCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		
		System.out.println("CourseCodeConstraintValidator : isValid " + theCourseCode);
		System.out.println("CourseCodeConstraintValidator : coursePrefix " + coursePrefix);
		System.out.println("CourseCodeConstraintValidator : getCoursePrefix() " + getCoursePrefix());
		if (theCourseCode != null) {
			result = theCourseCode.startsWith(getCoursePrefix());
		}
		else {
			result = false;
		}
		System.out.println("CourseCodeConstraintValidator : result " + result);
		return result;
	}

	public String getCoursePrefix() {
		return coursePrefix;
	}

	public void setCoursePrefix(String coursePrefix) {
		this.coursePrefix = coursePrefix;
	}

}
