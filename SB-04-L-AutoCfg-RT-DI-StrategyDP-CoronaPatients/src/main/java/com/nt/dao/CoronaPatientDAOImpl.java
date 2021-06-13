package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.CoronaPatientBO;

@Repository("dao")
public class CoronaPatientDAOImpl implements ICoronaPatientDAO {

	@Autowired
	private DataSource ds;
	private static final String GET_INFO_CITY = "SELECT ID, NAME, AGE, GENDER, CONTACT_NO, CITY, STATUS FROM CORONA_PATIENTS_INFO WHERE CITY=?";

	@Override
	public List<CoronaPatientBO> getCoronaPatientsData(String[] cities) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CoronaPatientBO bo = null;
		List<CoronaPatientBO> listBO = null;
		try {
			if (ds != null) {
				// get Connection obj
				con = ds.getConnection();
				if (con != null) {
					// create PreparedStatement obj
					ps = con.prepareStatement(GET_INFO_CITY);
					if (ps != null) {
						// create ListBO class object
						listBO = new ArrayList();
						for (int i = 0; i < cities.length; i++) {
							// set query param value(s)
							ps.setString(1, cities[i]);
							// send & execute sql query
							rs = ps.executeQuery();
							if (rs != null) {
								// prepare List of BO class objects by gathering records from ResultSet
								while (rs.next()) {
									// create BO object
									bo = new CoronaPatientBO();
									// set data to BO from records in ResultSet
									bo.setPatientId(rs.getInt(1));
									bo.setPatientName(rs.getString(2));
									bo.setAge(rs.getInt(3));
									bo.setGender(rs.getString(4).charAt(0));
									bo.setContactNo(rs.getLong(5));
									bo.setCity(rs.getString(6));
									bo.setStatus(rs.getString(7));
									// add BO object to listBO
									listBO.add(bo);
								} // while
							} // if -> rs
						} // for
					} // if -> ps
				} // if -> con
			} // if -> ds
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			// close ResultSet object
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				throw se;
			} catch (Exception e) {
				throw e;
			} // catch
				// close PreparedStatement object
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				throw se;
			} catch (Exception e) {
				throw e;
			} // catch
				// close Connection object
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				throw se;
			} catch (Exception e) {
				throw e;
			} // catch
		} // finally
		return listBO;
	}// getCoronaPatientsData(-)

}// class
