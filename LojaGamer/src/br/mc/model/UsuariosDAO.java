package br.mc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

public class UsuariosDAO {

	protected Connection connection = null;

	public Usuario consultarLogin(String email, String senha) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_clientes where email = ? and senha = ?;");
				statement.setString(1, email);
				statement.setString(2, senha);
				statement.execute();
				resultSet = statement.getResultSet();
				if (resultSet != null) {
					if (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String cpf = resultSet.getString("cpf");
						return new Usuario(id, email, senha, nome, email);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario consultarComFoto(int id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario usuario = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_clientes where id = ?;");
				statement.setInt(1, id);
				statement.execute();
				resultSet = statement.getResultSet();
				if (resultSet != null) {
					if (resultSet.next()) {
						String login = resultSet.getString("login");
						String senha = resultSet.getString("senha");
						String nome = resultSet.getString("nome");
						String email = resultSet.getString("email");
						//
						usuario = new Usuario(id, login, senha, nome, email);
						usuario.setFoto(resultSet.getBytes("foto"));
						usuario.setFotoType(resultSet.getString("fotoType"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Usuario> consultar() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_clientes;");
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

	public boolean adicionar(String login, String senha, String nome, String email, byte[] foto, String fotoType) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("insert into td_clientes(login, senha, nome, email, foto, fotoType) values(?, ?, ?, ?, ?, ?)");
				statement.setString(1, login);
				statement.setString(2, senha);
				statement.setString(3, nome);
				statement.setString(4, email);
				statement.setBlob(5, new SerialBlob(foto));
				statement.setString(6, fotoType);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(int id, String login, String senha, String nome, String email, byte[] foto, String fotoType) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("update td_clientes set login = ?, senha = ?, nome = ?, email = ?, foto = ?, fotoType = ? where id = ?");
				statement.setString(1, login);
				statement.setString(2, senha);
				statement.setString(3, nome);
				statement.setString(4, email);
				statement.setBlob(5, new SerialBlob(foto));
				statement.setString(6, fotoType);
				statement.setInt(7, id);
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
				statement = connection.prepareStatement("delete from td_clientes where id = ?");
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
