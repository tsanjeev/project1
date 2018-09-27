package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO{

	public void userInsert(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, TITLE,"
					+ "DEPARTMENT, AVAILABLE_AMT) VALUES (?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getTitle());
			stmt.setString(6, user.getDepartment());
			stmt.setDouble(7, user.getAvailableReimbursement());
			
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
			throw new Exception("Insert user failed: " + user);
		}

		
	}

	public void userUpdate(User user) throws Exception {
		// TODO Auto-generated method stub
			Connection connection = null;
			PreparedStatement stmt = null;
			int success = 0;
			try {
				connection = ConnectionUtil.getConnection();
				String sql = "UPDATE EMPLOYEE SET AVAILABLE_AMT = ? WHERE username= ?";

				stmt = connection.prepareStatement(sql);
				stmt.setDouble(1, user.getAvailableReimbursement());
				stmt.setString(2, user.getUserName());
				
				
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
				throw new Exception("Update User Failed: " + user);
			}
		}
		
	

	public void userDelete(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Delete From EMPLOYEE where username = ?";
	
		
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getUserName());
			
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
			throw new Exception("Delete Failed User:  " + user);
		}
	}

	public User getUserByCred(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		User newUser = new User();
		
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE username = ? AND password = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassWord());
						
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				newUser.setFirstName(rs.getString("firstname"));
				newUser.setLastName(rs.getString("lastname"));
				newUser.setUserName(rs.getString("username"));
				newUser.setPassWord(rs.getString("password"));
				newUser.setTitle(rs.getString("title"));
				newUser.setDepartment(rs.getString("department"));
				newUser.setAvailableReimbursement(rs.getInt("available_amt"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newUser;
	}

}
