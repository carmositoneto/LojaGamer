package br.mc.model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CarrinhoDAOMySqlLimpl extends CarrinhoDAO {
	
	public CarrinhoDAOMySqlLimpl() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojaonlinexyz?serverTimezone=UTC", "root",
					"123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
