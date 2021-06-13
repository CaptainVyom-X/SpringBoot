package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {

	List<EmployeeDTO> fetchEmpsByDesg(String[] desgs) throws Exception;

}
