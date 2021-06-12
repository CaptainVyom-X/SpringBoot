package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Named("java")
//@Primary
public final class JavaMaterial implements ICourseMaterial {

	public JavaMaterial() {
		System.out.println("JavaMaterial : 0-param constructor");
	}// constructor

	@Override
	public String courseContent() {
		System.out.println("JavaMaterial.courseContent()");
		return "Basics, OOPs, Collections";
	}// courseContent()

	@Override
	public double price() {
		System.out.println("JavaMaterial.price()");
		return 2000;
	}// price()

}// class
