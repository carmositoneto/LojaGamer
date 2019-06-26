package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

public abstract class ProdutosDAO {

	protected Connection connection = null;

	public ArrayList<Produto> consultar() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Produto produto = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_produtos");
				statement.execute();
				resultSet = statement.getResultSet();
				ArrayList<Produto> listProdutos = new ArrayList<Produto>();
				if (resultSet != null) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");
						produto = new Produto(id, nome, descricao);
						listProdutos.add(produto);
					}
				}
				return listProdutos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Produto consultar(int id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Produto produto = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_produtos where id = ?");
				statement.setInt(1, id);
				statement.execute();
				resultSet = statement.getResultSet();
				if (resultSet != null) {
					if (resultSet.next()) {
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");
						produto = new Produto(id, nome, descricao);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	public Integer adicionar(String nome, String descricao) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement(
						"insert into td_produtos(nome, descricao) values(?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, nome);
				statement.setString(2, descricao);

				statement.executeUpdate();

				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					return new Integer(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean alterar(int id, String nome, String descricao) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("update td_produtos set nome = ?, descricao = ? where id = ?");
				statement.setString(1, nome);
				statement.setString(2, descricao);
				statement.setInt(3, id);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remover(int id) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("delete from td_produtos where id = ?");
				statement.setInt(1, id);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
