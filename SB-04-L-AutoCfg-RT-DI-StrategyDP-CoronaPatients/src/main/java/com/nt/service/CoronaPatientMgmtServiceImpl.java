package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.CoronaPatientBO;
import com.nt.dao.ICoronaPatientDAO;
import com.nt.dto.CoronaPatientDTO;

@Service("service")
public class CoronaPatientMgmtServiceImpl implements ICoronaPatientMgmtService {

	@Autowired
	private ICoronaPatientDAO dao;

	@Override
	public List<CoronaPatientDTO> fetchCoronaPatientsData(String[] cities) throws Exception {
		List<CoronaPatientBO> listBO = null;
		List<CoronaPatientDTO> listDTO = null;
		CoronaPatientDTO dto = null;
		if (dao != null) {
			// use DAO
			listBO = dao.getCoronaPatientsData(cities);
			if (listBO != null) {
				// create listDTO object
				listDTO = new ArrayList();
				// convert listBO to listDTO
				for (CoronaPatientBO bo : listBO) {
					// create DTO object
					dto = new CoronaPatientDTO();
					// set BO data to DTO
					dto.setPatientId(bo.getPatientId());
					dto.setPatientName(bo.getPatientName());
					dto.setAge(bo.getAge());
					dto.setGender(bo.getGender());
					dto.setContactNo(bo.getContactNo());
					dto.setCity(bo.getCity());
					dto.setStatus(bo.getStatus());
					// add DTO object to listDTO
					listDTO.add(dto);
				} // for
			} // if -> listBO
		} // if -> dao
		return listDTO;
	}// fetchCoronaPatientsData(-)

}// class
