package br.mc.model;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

public class UsuariosDAO {

	protected Connection connection = null;

	public Usuario consultarLogin(BigInteger cpf, String senha) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_clientes where cpf = ? and senha = ?;");
				statement.setObject(1, cpf);
				statement.setString(2, senha);
				statement.execute();
				resultSet = statement.getResultSet();
				if (resultSet != null) {
					if (resultSet.next()) {
						String nome = resultSet.getString("nome");
						String email = resultSet.getString("email");
						boolean admin = resultSet.getBoolean("admininistrador");
						return new Usuario(cpf, senha, nome, email, admin);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario consultarComFoto(BigInteger cpf) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario usuario = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("select * from td_clientes where cpf = ?;");
				statement.setObject(1, cpf);
				statement.execute();
				resultSet = statement.getResultSet();
				if (resultSet != null) {
					if (resultSet.next()) {
						String senha = resultSet.getString("senha");
						String nome = resultSet.getString("nome");
						String email = resultSet.getString("email");
						boolean admin = resultSet.getBoolean("admininistrador");
						//
						usuario = new Usuario(cpf, senha, nome, email, admin);
						usuario.setImagem(resultSet.getBytes("foto"));
						usuario.setImagemTipo(resultSet.getString("fotoType"));
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
						BigInteger cpf = new BigInteger(resultSet.getString("cpf"));
						String senha = resultSet.getString("senha");
						String nome = resultSet.getString("nome");
						String email = resultSet.getString("email");
						boolean admin = resultSet.getBoolean("admininistrador");
						listUsuarios.add(new Usuario(cpf, senha, nome, email, admin));
					}
				}
				return listUsuarios;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean adicionar(BigInteger cpf, String senha, String nome, String email, boolean admin, byte[] imagem, String imagemTipo) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("insert into td_clientes(cpf, senha, nome, email, admininistrador, foto, fotoType) values(?, ?, ?, ?, ?, ?, ?)");
				statement.setObject(1, cpf);
				statement.setString(2, senha);
				statement.setString(3, nome);
				statement.setString(4, email);
				statement.setBoolean(5, admin);
				if(imagem.length > 0)
				{
					statement.setBlob(6, new SerialBlob(imagem));
				}
				else
				{
					statement.setObject(6, null);
				}
				statement.setString(7, imagemTipo);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(BigInteger cpf, String senha, String nome, String email, boolean admin, byte[] imagem, String imagemTipo) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("update tdusuarios set senha = ?, nome = ?, email = ?, admininistrador = ?, imagem = ?, imagemTipo = ? where cpf = ?");
				statement.setString(1, senha);
				statement.setString(2, nome);
				statement.setString(3, email);
				statement.setBoolean(4, admin);
				if(imagem.length > 0)
				{
					statement.setBlob(5, new SerialBlob(imagem));
				}
				else
				{
					statement.setObject(5, null);
				}
				statement.setString(6, imagemTipo);
				statement.setObject(7, cpf);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remover(BigInteger cpf) {
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				statement = connection.prepareStatement("delete from tdusuarios where cpf = ?");
				statement.setObject(1, cpf);
				statement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
