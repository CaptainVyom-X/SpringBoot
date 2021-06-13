package com.nt.service;

import java.util.List;

import com.nt.dto.CoronaPatientDTO;

public interface ICoronaPatientMgmtService {

	List<CoronaPatientDTO> fetchCoronaPatientsData(String[] cities) throws Exception;

}
