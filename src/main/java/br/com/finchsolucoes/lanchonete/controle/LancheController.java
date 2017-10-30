package br.com.finchsolucoes.lanchonete.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.finchsolucoes.lanchonete.dto.LancheDTO;
import br.com.finchsolucoes.lanchonete.dto.LancheIngredientesDTO;
import br.com.finchsolucoes.lanchonete.modelo.Lanche;
import br.com.finchsolucoes.lanchonete.modelo.LancheIngrediente;
import br.com.finchsolucoes.lanchonete.servico.LancheServico;

@RestController
public class LancheController {

  @Autowired
  private LancheServico lancheServico;
  
  @RequestMapping("/obter-todos")
  public List<Lanche> obterTodos(){
	return lancheServico.obterTodos();  
  };
  
  @RequestMapping("/obter-lanche-ingredientes") 
  public List<LancheIngrediente> obterIngredientes(LancheDTO lancheDTO) {
	  return lancheServico.obterIngrediente(lancheDTO.getId());
  }
  
 
  
}
