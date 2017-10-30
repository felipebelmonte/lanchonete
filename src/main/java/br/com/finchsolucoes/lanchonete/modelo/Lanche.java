package br.com.finchsolucoes.lanchonete.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Lanche {
	
	private long id;
	private String descricao;
	private List<LancheIngrediente> lancheIngredientes = new ArrayList<>();
	public double valor;

	public Lanche(long id, String descricao, List<LancheIngrediente> lancheIingredientes) {
		this.id = id;
		this.descricao = descricao;
		this.lancheIngredientes = lancheIingredientes;
	}
	
	public Lanche(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

    @JsonIgnore
	public List<LancheIngrediente> getLancheIngredientes() {
		return lancheIngredientes;
	}

	public void setLancheIngredientes(List<LancheIngrediente> lancheIngredientes) {
		this.lancheIngredientes = lancheIngredientes;
	}

	public Lanche adiciona(LancheIngrediente lancheIngrediente) {
		lancheIngredientes.add(lancheIngrediente);
		return this;
	}
		
	public Lanche(){ }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


}

