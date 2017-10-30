package br.com.finchsolucoes.lanchonete.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.finchsolucoes.lanchonete.dao.LanchesDAO;
import br.com.finchsolucoes.lanchonete.dto.IngredientesQtdDTO;
import br.com.finchsolucoes.lanchonete.dto.LancheIngredientesDTO;
import br.com.finchsolucoes.lanchonete.modelo.Ingredientes;
import br.com.finchsolucoes.lanchonete.modelo.Lanche;
import br.com.finchsolucoes.lanchonete.modelo.LancheIngrediente;

@Service
public class LancheServico {
	
 private static final int QUANTIDADE_MINIMA_DESCONTO = 3;
 private static final double VALOR_DESCONTO_LIGHT = 0.9;
 
  	
  public Lanche calculaValorLanche(Lanche lanche) {
     //Lanche lanche = (Lanche) lanchesDAO.busca(lancheId);
     double valor=0;
     
     for (LancheIngrediente i : lanche.getLancheIngredientes()) {
    	 valor += (i.getIngrediente().getPreco())*i.getQtde();
     }
     lanche.setValor(valor);
     
     return lanche;
  }
  
  public Lanche verificaLight(Lanche lanche) {
	  boolean cond1 = false;
	  boolean cond2 = true;
	  for (LancheIngrediente i : lanche.getLancheIngredientes()) {
		  if ("Alface".equals(i.getIngrediente().getNome())) {
			  cond1 = true;
		  }
		  if("Bacon".equals(i.getIngrediente().getNome())) {
			  cond2 = false;
		  }
      }
	  if (cond1 && cond2) {
	    	lanche.setValor((lanche.getValor() * VALOR_DESCONTO_LIGHT));  
	  }
		  
	  return lanche;
  }
  
  public Lanche verificaMuitaCarne(Lanche lanche) {
	    
	  Ingredientes hamburguer = new Ingredientes(3l,"Hambúrguer de carne",2);
	  
	  int totalHamburguer=0;
		for (LancheIngrediente i : lanche.getLancheIngredientes()) {
			if ("Hamburguer".equals(i.getIngrediente().getNome())) {
				totalHamburguer = i.getQtde();
				if (totalHamburguer >= 3) {
					double totalDesconto = new Long(totalHamburguer
													/ QUANTIDADE_MINIMA_DESCONTO).intValue()
													* hamburguer.getPreco();
					lanche.setValor(lanche.getValor() - totalDesconto);
				}
			}
		}

		return lanche;
  }
  
  public Lanche verificaMuitoQueijo(Lanche lanche) {
	  int totalQueijo=0;
	  Ingredientes queijo     = new Ingredientes(5l,"Queijo",1.50);
	  for (LancheIngrediente i : lanche.getLancheIngredientes()) {
			if ("Queijo".equals(i.getIngrediente().getNome())) {
				totalQueijo = i.getQtde();
				if (totalQueijo >= 3) {
					double totalDesconto = new Long(totalQueijo 
													/ QUANTIDADE_MINIMA_DESCONTO).intValue() 
													* queijo.getPreco();
					lanche.setValor(lanche.getValor() - totalDesconto);
				}
			}
		}

	  
	  return lanche;  
  }

public List<Lanche> obterTodos() {
	List<Lanche> lancheLista = new ArrayList<>();
	for(Lanche l : LanchesDAO.obterTodos()) {
		lancheLista.add(calculaValorLanche(l));
	};
	return lancheLista;
}

public List<LancheIngrediente> obterIngrediente(Long id){
	return LanchesDAO.obterIngredientes(id);
}
    
public Lanche saveEdit(LancheIngredientesDTO lancheIngredientesDTO) {
	Lanche lanche = LanchesDAO.busca(Long.valueOf(lancheIngredientesDTO.getIdLanche()));
	List<LancheIngrediente> edicaoListaIngreditens = new ArrayList<>();
	
	for (IngredientesQtdDTO dto : lancheIngredientesDTO.getIngredienteQtdDTOList()) {
		for (LancheIngrediente i : edicaoListaIngreditens) {
		}
	    if (dto.getQtde() != 0) {
			Ingredientes ingredientes = LanchesDAO.buscaIngrediente(dto.getId());
			if (!edicaoListaIngreditens.contains(ingredientes)){
				LancheIngrediente novoIngrediente = new LancheIngrediente();
				novoIngrediente.setIngrediente(ingredientes);
				novoIngrediente.setQtde(dto.getQtde());
				edicaoListaIngreditens.add(novoIngrediente);
			}	
		}
		
	}
	lanche.setLancheIngredientes(edicaoListaIngreditens);
	
	lanche = calculaValorLanche(lanche);
	
	lanche = verificaLight(lanche);
	lanche = verificaMuitaCarne(lanche);
	lanche = verificaMuitoQueijo(lanche);
	
	return lanche;
}

}
