package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

	protected Connection connection = null;
	public ArrayList<Usuario> listarProdutos(){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from usuarios;");
				statement.execute();
				resultSet = statement.getResultSet();
				ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();
				if (resultSet != null) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String login = resultSet.getString("login");
						String senha = resultSet.getString("senha");
						String nome = resultSet.getString("nome");
						String email = resultSet.getString("email");
						listUsuarios.add(new Usuario(id, login, senha, nome, email));
					}
				}
				return listUsuarios;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
