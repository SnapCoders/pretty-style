package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection createConnection() throws SQLException {
		String database = "db_pretty_style";
		String user = "root";
		String password = "9Km#47mK";
		
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + database + "?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false", user, password);
	}
}
