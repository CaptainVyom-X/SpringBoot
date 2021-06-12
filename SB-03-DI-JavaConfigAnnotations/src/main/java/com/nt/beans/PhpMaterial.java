package com.nt.beans;

import javax.inject.Named;

@Named("php")
public final class PhpMaterial implements ICourseMaterial {

	public PhpMaterial() {
		System.out.println("PhpMaterial : 0-param constructor");
	}// constructor

	@Override
	public String courseContent() {
		System.out.println("PhpMaterial.courseContent()");
		return "Php-Basics, Php-OOPs, Php-Collections";
	}// courseContent()

	@Override
	public double price() {
		System.out.println("PhpMaterial.price()");
		return 1000;
	}// price()

}// class
