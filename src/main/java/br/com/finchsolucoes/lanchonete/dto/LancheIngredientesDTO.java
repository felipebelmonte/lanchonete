package br.com.finchsolucoes.lanchonete.dto;

import java.util.List;

import lombok.Data;

@Data
public class LancheIngredientesDTO {
	
	private Integer idLanche;
	private List<IngredientesQtdDTO> ingredienteQtdDTOList;

	public LancheIngredientesDTO() {
	}

	public LancheIngredientesDTO(Integer idLanche,
			List<IngredientesQtdDTO> ingredienteQtdDTOList) {
		this.idLanche = idLanche;
		this.ingredienteQtdDTOList = ingredienteQtdDTOList;
	}

	public Integer getIdLanche() {
		return idLanche;
	}

	public void setIdLanche(Integer idLanche) {
		this.idLanche = idLanche;
	}

	public List<IngredientesQtdDTO> getIngredienteQtdDTOList() {
		return ingredienteQtdDTOList;
	}

	public void setIngredienteQtdDTOList(
			List<IngredientesQtdDTO> ingredienteQtdDTOList) {
		this.ingredienteQtdDTOList = ingredienteQtdDTOList;
	}
}
