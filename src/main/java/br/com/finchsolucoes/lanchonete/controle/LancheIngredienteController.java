package br.com.finchsolucoes.lanchonete.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.finchsolucoes.lanchonete.dto.LancheIngredientesDTO;
import br.com.finchsolucoes.lanchonete.modelo.Lanche;
import br.com.finchsolucoes.lanchonete.servico.LancheServico;

@RestController
@RequestMapping("/edit")
public class LancheIngredienteController {

	@Autowired
	private LancheServico lancheServico;
	
	@RequestMapping(method = RequestMethod.POST)
	public Lanche saveEdit(@RequestBody LancheIngredientesDTO lancheIngredientesDTO) {
		  return lancheServico.saveEdit(lancheIngredientesDTO);	
	}
}
