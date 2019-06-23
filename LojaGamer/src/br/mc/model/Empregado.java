package br.mc.model;

public class Empregado {
	
	private int id;
	private int cpf;
	private String nome;
	private String email;
	private String senha;
	private byte[] foto;
	private String fotoType;
	private String funcao;
	
	public Empregado(int id, int cpf, String nome, String email, String senha, byte[] foto,
			String fotoType, String funcao ) {

		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.fotoType = fotoType;
		this.funcao = funcao;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getFotoType() {
		return fotoType;
	}

	public void setFotoType(String fotoType) {
		this.fotoType = fotoType;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
	



}
