package br.com.finchsolucoes.lanchonete.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.finchsolucoes.lanchonete.modelo.Ingredientes;
import br.com.finchsolucoes.lanchonete.servico.IngredienteServico;

@RestController
public class IngredienteController {
	
	@Autowired
	private IngredienteServico ingredienteServico;
	  
	  @RequestMapping("/obter-ingredientes")
	  public List<Ingredientes> obterTodos(){
		return ingredienteServico.obterTodos();  
	  };

}
