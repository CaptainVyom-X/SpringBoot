package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {

	List<EmployeeBO> getEmpsByDesg(String condition) throws Exception;

}
