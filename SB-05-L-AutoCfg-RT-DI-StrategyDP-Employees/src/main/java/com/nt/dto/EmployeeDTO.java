package com.nt.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Integer sno;
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Double sal;

}
