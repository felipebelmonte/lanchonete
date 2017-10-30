package br.com.finchsolucoes.lanchonete.dto;

import lombok.Data;

@Data
public class IngredientesQtdDTO {
	
	private Integer id;
	private Integer qtde;

	public IngredientesQtdDTO() {
	}

	public IngredientesQtdDTO(Integer id, Integer qtde) {
		this.id = id;
		this.qtde = qtde;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

}
