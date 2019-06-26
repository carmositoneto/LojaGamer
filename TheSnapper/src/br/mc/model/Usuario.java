package br.mc.model;

import java.math.BigInteger;

public class Usuario {
	private BigInteger cpf;
	private String senha;
	private String nome;
	private String email;
	private boolean admin;
	private byte[] imagem;
	private String imagemTipo;
	
	public Usuario(BigInteger id, String senha, String nome, String email, boolean admin) {
		this.cpf = id;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.admin = admin;
	}
	
	public BigInteger getCpf() {
		return cpf;
	}
	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getImagemTipo() {
		return imagemTipo;
	}

	public void setImagemTipo(String imagemTipo) {
		this.imagemTipo = imagemTipo;
	}
}
