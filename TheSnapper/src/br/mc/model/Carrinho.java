package br.mc.model;

public class Carrinho {
	
	private int id_carrinho;
	private String nome_produto;
	private String descricao_produto;
	
	
	public Carrinho(int id, String nome, String descricao) {
		
		setId_carrinho(id);
		setNome_produto(nome);;
		setDescricao_produto(descricao);;

	}
	
	

	public int getId_carrinho() {
		return id_carrinho;
	}



	public void setId_carrinho(int id_carrinho) {
		this.id_carrinho = id_carrinho;
	}



	public String getNome_produto() {
		return nome_produto;
	}



	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}



	public String getDescricao_produto() {
		return descricao_produto;
	}



	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}



	@Override
	public String toString() {
		return getNome_produto();
	}
	

}
