package com.nt.bo;

import lombok.Data;

@Data
public class EmployeeBO {

	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Double sal;

}
