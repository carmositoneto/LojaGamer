package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

	protected Connection connection = null;
	public ArrayList<Produtos> listarProdutos(){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from produtos;");
				statement.execute();
				resultSet = statement.getResultSet();
				ArrayList<Produtos> listProdutos = new ArrayList<Produtos>();
				if (resultSet != null) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String desc = resultSet.getString("desc");
						listProdutos.add(new Produtos(id, nome, desc));
					}
				}
				return listProdutos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
