package br.com.finchsolucoes.lanchonete.dto;

import lombok.Data;

@Data
public class LancheDTO {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
