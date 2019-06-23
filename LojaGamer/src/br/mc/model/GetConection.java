package br.mc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConection {
	
	
	public Connection  getConectionCarmo() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojaonlinexyz?serverTimezone=UTC", "root",
					"amand@123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public  Connection getConectionZe() {


		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojaonlinexyz?serverTimezone=UTC", "root",
					"amand@123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
