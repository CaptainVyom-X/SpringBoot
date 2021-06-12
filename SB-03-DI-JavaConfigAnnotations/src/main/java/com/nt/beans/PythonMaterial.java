package com.nt.beans;

import javax.inject.Named;

@Named("python")
public final class PythonMaterial implements ICourseMaterial {

	public PythonMaterial() {
		System.out.println("PythonMaterial : 0-param constructor");
	}// constructor

	@Override
	public String courseContent() {
		System.out.println("PythonMaterial.courseContent()");
		return "P-Basics, P-OOPs, P-Collections";
	}// courseContent()

	@Override
	public double price() {
		System.out.println("PythonMaterial.price()");
		return 3000;
	}// price()

}// class
