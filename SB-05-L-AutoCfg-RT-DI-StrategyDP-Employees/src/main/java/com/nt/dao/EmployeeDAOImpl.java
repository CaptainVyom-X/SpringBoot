package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_DETAILS_BY_DESG = "SELECT EMPNO, ENAME, JOB, MGR, SAL FROM EMP WHERE JOB IN ";
	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpsByDesg(String condition) throws Exception {
		EmployeeBO bo = null;
		List<EmployeeBO> listBO = null;
		try ( // get Connection object
				Connection con = ds.getConnection();
				// create Statement object
				Statement st = con.createStatement();
				// send & execute the query
				ResultSet rs = st.executeQuery(GET_EMP_DETAILS_BY_DESG + condition + "ORDER BY JOB");) {
			// create ListBO
			listBO = new ArrayList();
			// set the records in ResultSet to BO object
			while (rs.next()) {
				// create BO object
				bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setMgr(rs.getInt(4));
				bo.setSal(rs.getDouble(5));
				// add BO to listBO
				listBO.add(bo);
			} // while
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} // catch
		return listBO;
	}// getEmpsByDesg(-)

}// class
