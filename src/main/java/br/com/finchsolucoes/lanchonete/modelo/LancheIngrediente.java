package br.com.finchsolucoes.lanchonete.modelo;

import lombok.Data;

@Data
public class LancheIngrediente {
	
	private long   id;
	private Lanche lanche;
	private Ingredientes ingrediente;
	private int     qtde;
	

	public LancheIngrediente(long id, Lanche lanche, Ingredientes ingrediente, int qtde) {
		this.id = id;
		this.lanche = lanche;
		this.ingrediente = ingrediente;
		this.qtde = qtde;
	}
	public LancheIngrediente() {
		
	}	
	public Lanche getLanche() {
		return lanche;
	}
	public long getId() {
		return id;
	}
	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}
	public Ingredientes getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingredientes ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	

}
