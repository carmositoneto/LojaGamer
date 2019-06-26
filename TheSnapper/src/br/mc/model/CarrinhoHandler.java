package br.mc.model;

import java.util.ArrayList;

public class CarrinhoHandler {
	
	CarrinhoDAOMySqlLimpl carrinho = new CarrinhoDAOMySqlLimpl();
	
	
	public ArrayList<Carrinho> consultar() {
		return carrinho.consultar();
	}

	public String consultarNumItens() {
		return carrinho.consultarNumItens();
	}

	public boolean adicionar(int id_produto) {
		return carrinho.adicionar(id_produto);
	}


	public boolean remover(int id_carrinho) {
		return carrinho.remover(id_carrinho);
	}

}
