package br.mc.model;

import java.util.ArrayList;

public class UsuarioHandler {
	UsuariosDAO usuariosDAO = new UsuariosDAOMySQLImpl();

	public Usuario consultarLogin(String login, String senha) {
		return usuariosDAO.consultarLogin(login, senha);
	}

	public Usuario consultarComFoto(int id) {
		return usuariosDAO.consultarComFoto(id);
	}

	public ArrayList<Usuario> consultar() {
		return usuariosDAO.consultar();
	}

	public boolean adicionar(String login, String senha, String nome, String email, byte[] foto, String fotoType) {
		return usuariosDAO.adicionar(login, senha, nome, email, foto, fotoType);
	}

	public boolean alterar(int id, String login, String senha, String nome, String email, byte[] foto, String fotoType) {
		return usuariosDAO.alterar(id, login, senha, nome, email, foto, fotoType);
	}

	public boolean remover(int id) {
		return usuariosDAO.remover(id);
	}
}
