package br.mc.model;

import java.util.Date;

public class HistoricoPrecos {
	int id; 
    int produto;
    double preco ;
    Date data;
    String imagem;
    
    
    
    public HistoricoPrecos(int id, int produto, double preco, Date data, String imagem) {
		this.id = id;
		this.produto = produto;
		this.preco = preco;
		this.data = data;
		this.imagem = imagem;	
    }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getProduto() {
		return produto;
	}



	public void setProduto(int produto) {
		this.produto = produto;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getImagem() {
		return imagem;
	}



	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
    
    
    
    

}
