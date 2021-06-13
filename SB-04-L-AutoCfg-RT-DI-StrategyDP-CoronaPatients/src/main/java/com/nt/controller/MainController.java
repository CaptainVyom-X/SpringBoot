package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CoronaPatientDTO;
import com.nt.service.ICoronaPatientMgmtService;
import com.nt.vo.CoronaPatientVO;

@Controller("controller")
public class MainController {

	@Autowired
	private ICoronaPatientMgmtService service;

	public List<CoronaPatientVO> collectCoronaPatientsData(String[] cities) throws Exception {
		List<CoronaPatientDTO> listDTO = null;
		List<CoronaPatientVO> listVO = null;
		CoronaPatientVO vo = null;
		if (service != null) {
			// use Service
			listDTO = service.fetchCoronaPatientsData(cities);
			if (listDTO != null) {
				// create listVO object
				listVO = new ArrayList();
				// convert listDTO to listVO
				for (CoronaPatientDTO dto : listDTO) {
					// create VO object
					vo = new CoronaPatientVO();
					// set data to VO from DTO
					vo.setPatientId(String.valueOf(dto.getPatientId()));
					vo.setPatientName(dto.getPatientName());
					vo.setAge(String.valueOf(dto.getAge()));
					vo.setGender(String.valueOf(dto.getGender()));
					vo.setContactNo(String.valueOf(dto.getContactNo()));
					vo.setCity(dto.getCity());
					vo.setStatus(dto.getStatus());
					// add VO to listVO
					listVO.add(vo);
				} // for
			} // if -> listDTO
		} // if -> service
		return listVO;
	}// collectCoronaPatientsData(-)

}// class
