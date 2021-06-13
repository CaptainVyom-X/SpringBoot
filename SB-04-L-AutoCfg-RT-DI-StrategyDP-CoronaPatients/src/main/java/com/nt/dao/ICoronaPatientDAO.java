package com.nt.dao;

import java.util.List;

import com.nt.bo.CoronaPatientBO;

public interface ICoronaPatientDAO {

	List<CoronaPatientBO> getCoronaPatientsData(String[] cities) throws Exception;

}
