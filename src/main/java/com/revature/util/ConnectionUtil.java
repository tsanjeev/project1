package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://mydb.cd2berwkughw.us-east-2.rds.amazonaws.com:5432/myDB?";
		String user = "tsanjeev";
		String password = "revatureFullStax87";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, user, password);
	}
}
