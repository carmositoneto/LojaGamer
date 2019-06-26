package br.mc.model;

import java.math.BigInteger;
import java.util.ArrayList;

public class UsuarioHandler {
	UsuariosDAO usuariosDAO = new UsuariosDAOMySQLImpl();

	public Usuario consultarLogin(BigInteger cpf, String senha) {
		return usuariosDAO.consultarLogin(cpf, senha);
	}

	public Usuario consultarComFoto(BigInteger cpf) {
		return usuariosDAO.consultarComFoto(cpf);
	}

	public ArrayList<Usuario> consultar() {
		return usuariosDAO.consultar();
	}

	public boolean adicionar(BigInteger cpf, String senha, String nome, String email, boolean admin, byte[] imagem, String imagemTipo) {
		return usuariosDAO.adicionar(cpf, senha, nome, email, admin, imagem, imagemTipo);
	}

	public boolean alterar(BigInteger cpf, String senha, String nome, String email, boolean admin, byte[] imagem, String imagemTipo) {
		return usuariosDAO.alterar(cpf, senha, nome, email, admin, imagem, imagemTipo);
	}

	public boolean remover(BigInteger cpf) {
		return usuariosDAO.remover(cpf);
	}
}
