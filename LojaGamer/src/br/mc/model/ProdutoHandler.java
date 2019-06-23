package br.mc.model;

import java.util.List;

public class ProdutoHandler {
	
	ProdutosDAO produtoDao = new ProdutosDAOMySQLImpl();
	
	
	public List<Produto> consultarLogin() {
		return produtoDao.listarProdutos();
	}
	

}
