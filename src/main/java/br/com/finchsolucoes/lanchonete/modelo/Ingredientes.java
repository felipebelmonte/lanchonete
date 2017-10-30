package br.com.finchsolucoes.lanchonete.modelo;

import lombok.Data;

@Data
public class Ingredientes {
	
	private long    id;
	private String nome;
	private double preco;
	
	public Ingredientes() {}
	
	public Ingredientes(long id, String nome, double preco) {
	  this.id = id;
	  this.nome = nome;
	  this.preco = preco;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
