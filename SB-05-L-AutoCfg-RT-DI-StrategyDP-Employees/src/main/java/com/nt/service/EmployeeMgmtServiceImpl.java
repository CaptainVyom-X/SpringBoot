package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesg(String[] desgs) throws Exception {
		StringBuilder buffer = null;
		String condition = null;
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList();
		// prepare condition for sql query based on desgs
		// ('CLERK', 'MANAGER', 'ANALYIST')
		buffer = new StringBuilder("(");
		for (int i = 0; i < desgs.length; i++) {
			if (i == desgs.length - 1)
				buffer.append("'" + desgs[i].toUpperCase() + "')");
			else
				buffer.append("'" + desgs[i].toUpperCase() + "', ");
		} // for
			// create the condition in String format
			// condition = new String(buffer);
		condition = buffer.toString();
		// use DAO
		listBO = dao.getEmpsByDesg(condition);
		// convert ListDTO to ListBO
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			// copy data from BO to DTO
			// names and datatypes of both java beans properties must match
			BeanUtils.copyProperties(bo, dto);
			dto.setSno(listDTO.size() + 1);
			// add dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}// fetchEmpsByDesgs(-)

}// class
