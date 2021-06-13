package com.nt.bo;

import lombok.Data;

@Data
public class CoronaPatientBO {

	private int patientId;
	private String patientName;
	private int age;
	private char gender;
	private long contactNo;
	private String city;
	private String status;

}
