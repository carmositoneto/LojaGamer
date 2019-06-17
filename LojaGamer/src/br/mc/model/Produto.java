package br.mc.model;

public class Produto {
	int id;
	String nome;
	String desc;

	public Produto(int id, String nome, String desc) {
		this.id = id;
		this.nome = nome;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
