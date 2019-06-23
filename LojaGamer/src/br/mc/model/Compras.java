package br.mc.model;

import java.util.Date;

public class Compras {
	
	int id;
	int cliente;
	int empregado;
	Date data;
	
	public Compras(int id, int cliente, int empregado, Date data) {
		
		this.id = id;
		this.cliente = cliente;
		this.empregado = empregado;
		this.data = data;
	
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCliente() {
		return cliente;
	}



	public void setCliente(int cliente) {
		this.cliente = cliente;
	}



	public int getEmpregado() {
		return empregado;
	}



	public void setEmpregado(int empregado) {
		this.empregado = empregado;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}
	
	
	

}
