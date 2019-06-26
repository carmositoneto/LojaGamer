package br.mc.model;

import java.util.ArrayList;

public class ProdutoHandler {
	ProdutosDAO produtosDAO = new ProdutosDAOMySQLImpl();

	public ArrayList<Produto> consultar() {
		return produtosDAO.consultar();
	}

	public Produto consultar(int id) {
		return produtosDAO.consultar(id);
	}

	public Integer adicionar(String nome, String descricao) {
		return produtosDAO.adicionar(nome, descricao);
	}

	public boolean alterar(int id, String nome, String descricao) {
		return produtosDAO.alterar(id, nome, descricao);
	}

	public boolean remover(int id) {
		return produtosDAO.remover(id);
	}
}
