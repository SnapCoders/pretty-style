package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	//Apagar a senha
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/SistemaPaises?useTimezone=true&serverTimezone=UTC&useSSL=false&user=root&password=root");
	}
}
