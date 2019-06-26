package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoDAO {
	
	protected Connection connection = null;
	
	
	public ArrayList<Carrinho> consultar() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Carrinho carrinho = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select l.id, p.nome,p.descricao from td_lista_carrinho l join td_produtos p on p.id = l.produto");
				statement.execute();
				resultSet = statement.getResultSet();
				ArrayList<Carrinho> listCarrinhos = new ArrayList<Carrinho>();
				if (resultSet != null) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");
						carrinho = new Carrinho(id, nome, descricao);
						listCarrinhos.add(carrinho);
					}
				}
				return listCarrinhos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String consultarNumItens() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String resulte = "";
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select count(l.id) as num from td_lista_carrinho l join td_produtos p on p.id = l.produto");
				statement.execute();
				resultSet = statement.getResultSet();

				if (resultSet != null) {
					while (resultSet.next()) {
						int num = resultSet.getInt("num");
						
						resulte = "Voce tem "+ num + " inten(s) no carrinho";
					}
				}
				return resulte;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean adicionar(int id_produto) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("insert into td_lista_carrinho (produto) values(?);");
				statement.setInt(1, id_produto);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean remover(int id_lista ) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("delete from td_lista_carrinho where id = ? ");
				statement.setInt(1, id_lista);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
