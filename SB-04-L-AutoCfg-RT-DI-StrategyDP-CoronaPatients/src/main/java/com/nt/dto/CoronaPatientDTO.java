package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CoronaPatientDTO implements Serializable {

	private int patientId;
	private String patientName;
	private int age;
	private char gender;
	private long contactNo;
	private String city;
	private String status;

}
