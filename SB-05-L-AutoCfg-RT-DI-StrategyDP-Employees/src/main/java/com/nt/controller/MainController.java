package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	@Autowired
	private IEmployeeMgmtService service;

	public List<EmployeeVO> displayEmpsByDesgs(String[] desgs) throws Exception {
		List<EmployeeDTO> listDTO = null;
		List<EmployeeVO> listVO = new ArrayList();
		// use service
		listDTO = service.fetchEmpsByDesg(desgs);
		// convert listDTO to listVO
		listDTO.forEach(dto -> {
			EmployeeVO vo = new EmployeeVO();
			// add data from dto to vo
			BeanUtils.copyProperties(dto, vo);
			vo.setSno(String.valueOf(dto.getSno()));
			vo.setEmpno(String.valueOf(dto.getEmpno()));
			vo.setMgr(String.valueOf(dto.getMgr()));
			vo.setSal(String.valueOf(dto.getSal()));
			// add vo to listVO
			listVO.add(vo);
		});
		return listVO;
	}// displayEmpsByDesgs(-)

}// class
