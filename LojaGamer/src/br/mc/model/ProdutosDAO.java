package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

	protected Connection connection = null;
	
	
	public ArrayList<Produto> listarProdutos(){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_produtos;");
				statement.execute();
				resultSet = statement.getResultSet();
				ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
				if (resultSet != null) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String desc = resultSet.getString("descricao");
						listaDeProdutos.add(new Produto(id, nome, desc));
					}
				}
				return listaDeProdutos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
