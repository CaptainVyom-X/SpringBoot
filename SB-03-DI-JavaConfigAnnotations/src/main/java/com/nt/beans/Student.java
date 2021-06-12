package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Named("std")
public final class Student {

	@Inject
	// @Named("php")
	@Named("courseId")
	// @Resource(name = "python")
	// @Resource(name = "courseId")
	private ICourseMaterial material; // HAS-A Property

	public Student() {
		System.out.println("Student : 0-param constructor");
	}// constructor

	// business method
	public void perpare(String examName) {
		String courseContent = null;
		double price = 0;
		System.out.println("Student is preparing for" + examName);
		courseContent = material.courseContent();
		price = material.price();
		System.out.println("Student bought books " + courseContent + " for ₹" + price);
		System.out.println("Student completed preparing for " + examName);
	}// prepare(-)

}// class
