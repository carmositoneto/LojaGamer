package br.mc.model;

public class ListaDecompras {
	int id; 
    int compra;
    int poduto;
    int quantidade;
    int preco;
    
    
    public ListaDecompras (int id, int compra, int produto, int quantidade, int preco) {
    	
    	this.id = id;
    	this.compra = compra;
    	this.poduto = produto;
    	this.quantidade = quantidade;
    	this.preco = preco;
    	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCompra() {
		return compra;
	}


	public void setCompra(int compra) {
		this.compra = compra;
	}


	public int getPoduto() {
		return poduto;
	}


	public void setPoduto(int poduto) {
		this.poduto = poduto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getPreco() {
		return preco;
	}


	public void setPreco(int preco) {
		this.preco = preco;
	}
    
    
    
    
}
