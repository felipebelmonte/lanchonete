package br.com.finchsolucoes.lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.finchsolucoes.lanchonete.dao.LanchesDAO;
import br.com.finchsolucoes.lanchonete.modelo.Ingredientes;

@Service
public class IngredienteServico {
    
	public List<Ingredientes> obterTodos() {
		return LanchesDAO.obterIngredientes();
	}
	
}
