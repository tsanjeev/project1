package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Event;
import com.revature.pojos.Form;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class RformDAOImp implements RformDAO{
	
	
	public void formInsert(Form form) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO RFORM (EMPLOYEEID, FIRSTNAME, LASTNAME, LOCATION, CITY, STATE, ZIP, DESCRIPTION, STATUS, CURR_DATE,"
					+ "START_DATE, START_TIME, GRADE_FORMAT, EVENT, JUSTIFICATION, COST, PROJECTED) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, form.getEmployeeID());
			stmt.setString(2, form.getFirstname());
			stmt.setString(3, form.getLastname());
			stmt.setString(4, form.getLocation());
			stmt.setString(5, form.getCity());
			stmt.setString(6, form.getState());
			stmt.setString(7, form.getZip());
			stmt.setString(8, form.getDescription());
			stmt.setInt(9, form.getStatus());
			stmt.setString(10, form.getCurrDate());
			stmt.setString(11, form.getStartDate());
			stmt.setString(12, form.getTime());
			stmt.setString(13, form.getGrade());
			stmt.setString(14, form.getEventType());
			stmt.setString(15, form.getJustification());
			stmt.setDouble(16, form.getCost());
			stmt.setDouble(17, form.getProjected());
			
			success = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Insert Form failed: " + form);
		}

		
	}
	
	public void formDeleteSoft(Form form) throws Exception{
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE RFORM SET STATUS = ? WHERE EMPLOYEEID= ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, form.getStatus());
			stmt.setInt(2, form.getEmployeeID());
			
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Soft Delete Form Failed: " + form);
		}
	}
	
	public void formUpdateStatus(int id, int status) throws Exception {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE RFORM SET STATUS = ? WHERE RFORMID = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setInt(2, id);
			
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Update Form Status Failed: " + id);
		}
		
	}
	
	public void formDeleteHard(Form form) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM RFORM WHERE EMPLOYEEID = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, form.getEmployeeID());
			
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Hard Delete Form Failed: " + form);
		}
	}
	
	public ArrayList<Form> getAllForms(User user) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ArrayList<Form> formsList = new ArrayList<Form>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RFORM WHERE EMPLOYEEID != ? OR STATUS != ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getEmployeeID());
			stmt.setInt(2, 3);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Form form = new Form();

				form.setFormID(rs.getInt("RFORMID"));
				form.setEmployeeID(rs.getInt("EMPLOYEEID"));
				form.setFirstname(rs.getString("FIRSTNAME"));
				form.setLastname(rs.getString("LASTNAME"));
				form.setLocation(rs.getString("LOCATION"));
				form.setCity(rs.getString("CITY"));
				form.setState(rs.getString("STATE"));
				form.setZip(rs.getString("ZIP"));
				form.setDescription(rs.getString("DESCRIPTION"));
				form.setStatus(rs.getInt("STATUS"));
				
				form.setCurrDate(rs.getString("CURR_DATE"));
				form.setStartDate(rs.getString("START_DATE"));
				form.setTime(rs.getString("START_TIME"));
				form.setGrade(rs.getString("GRADE_FORMAT"));
				form.setEventType(rs.getString("EVENT"));
				form.setJustification(rs.getString("JUSTIFICATION"));
				form.setCost(rs.getDouble("COST"));
				form.setProjected(rs.getDouble("PROJECTED"));
				
				formsList.add(form);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return formsList;
	}

	public ArrayList<Form> getAllFormsForUser(User user) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ArrayList<Form> formsList = new ArrayList<Form>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RFORM WHERE EMPLOYEEID = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getEmployeeID());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Form form = new Form();

				form.setFormID(rs.getInt("RFORMID"));
				form.setEmployeeID(rs.getInt("EMPLOYEEID"));
				form.setFirstname(rs.getString("FIRSTNAME"));
				form.setLastname(rs.getString("LASTNAME"));
				form.setLocation(rs.getString("LOCATION"));
				form.setCity(rs.getString("CITY"));
				form.setState(rs.getString("STATE"));
				form.setZip(rs.getString("ZIP"));
				form.setDescription(rs.getString("DESCRIPTION"));
				form.setStatus(rs.getInt("STATUS"));
				
				form.setCurrDate(rs.getString("CURR_DATE"));
				form.setStartDate(rs.getString("START_DATE"));
				form.setTime(rs.getString("START_TIME"));
				form.setGrade(rs.getString("GRADE_FORMAT"));
				form.setEventType(rs.getString("EVENT"));
				form.setJustification(rs.getString("JUSTIFICATION"));
				form.setCost(rs.getDouble("COST"));
				form.setProjected(rs.getDouble("PROJECTED"));
				
				formsList.add(form);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return formsList;
	}
	
	public Form getAForm(int id) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		Form form = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RFORM WHERE RFORMID = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				form = new Form();

				form.setFormID(rs.getInt("RFORMID"));
				form.setEmployeeID(rs.getInt("EMPLOYEEID"));
				form.setFirstname(rs.getString("FIRSTNAME"));
				form.setLastname(rs.getString("LASTNAME"));
				form.setLocation(rs.getString("LOCATION"));
				form.setCity(rs.getString("CITY"));
				form.setState(rs.getString("STATE"));
				form.setZip(rs.getString("ZIP"));
				form.setDescription(rs.getString("DESCRIPTION"));
				form.setStatus(rs.getInt("STATUS"));
				
				form.setCurrDate(rs.getString("CURR_DATE"));
				form.setStartDate(rs.getString("START_DATE"));
				form.setTime(rs.getString("START_TIME"));
				form.setGrade(rs.getString("GRADE_FORMAT"));
				form.setEventType(rs.getString("EVENT"));
				form.setJustification(rs.getString("JUSTIFICATION"));
				form.setCost(rs.getDouble("COST"));
				form.setProjected(rs.getDouble("PROJECTED"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return form;
	}
}
