package br.com.finchsolucoes.lanchonete.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.finchsolucoes.lanchonete.modelo.Ingredientes;
import br.com.finchsolucoes.lanchonete.modelo.Lanche;
import br.com.finchsolucoes.lanchonete.modelo.LancheIngrediente;

public class LanchesDAO {
	private static Map<Long, Lanche> banco = new HashMap<Long, Lanche>();
	private static List<Ingredientes> bancoIngredientes = new ArrayList<>();
	static {
		Ingredientes alface     = new Ingredientes(1l,"Alface",0.40);
		Ingredientes bacon      = new Ingredientes(2l,"Bacon",2);
		Ingredientes hamburguer = new Ingredientes(3l,"Hambúrguer de carne",2);
		Ingredientes ovo        = new Ingredientes(4l,"Ovo",0.80);
		Ingredientes queijo     = new Ingredientes(5l,"Queijo",1.50);
		
		Lanche xbacon    = new Lanche(1l,"X-Bacon");
		Lanche xburguer  = new Lanche(2l,"X-Burguer");
		Lanche xegg      = new Lanche(3l,"X-Egg");
		Lanche xeggbacon = new Lanche(4l,"X-Egg Bacon");
		
		
		xbacon.setLancheIngredientes(Arrays.asList(new LancheIngrediente(1l, xbacon, bacon, 1),
				                                   new LancheIngrediente(2l, xbacon, hamburguer, 1),
				                                   new LancheIngrediente(3l, xbacon, queijo, 1)));
		
		xburguer.setLancheIngredientes(Arrays.asList(new LancheIngrediente(4l, xburguer, hamburguer, 1),
                									 new LancheIngrediente(4l, xburguer, queijo, 1)));
		
		xegg.setLancheIngredientes(Arrays.asList(new LancheIngrediente(5l, xegg, ovo, 1),
												 new LancheIngrediente(6l, xegg, hamburguer, 1),
												 new LancheIngrediente(7l, xegg, queijo, 1)));
		
		xeggbacon.setLancheIngredientes(Arrays.asList(new LancheIngrediente(5l, xegg, ovo, 1),
				 new LancheIngrediente(6l, xegg, hamburguer, 1),
				 new LancheIngrediente(2l, xegg, bacon, 1),
				 new LancheIngrediente(7l, xegg, queijo, 1)));
		
	  banco.put(1l, xbacon);
	  banco.put(2l, xburguer);
	  banco.put(3l, xegg);
	  banco.put(4l, xeggbacon);
	  
	  bancoIngredientes.add(alface);
	  bancoIngredientes.add(bacon);
	  bancoIngredientes.add(hamburguer);
	  bancoIngredientes.add(ovo);
	  bancoIngredientes.add(queijo);
	  
	}
	
	public static Lanche busca(Long id) {
		return banco.get(id);
	}
	
	public static Ingredientes buscaIngrediente(int id) {
		for (Ingredientes i : bancoIngredientes) {
			if (i.getId() == Long.valueOf(id)) {
				return i;
			}
		}
		return null;
	}
	
	
	public Lanche remove(long id) {
		return banco.remove(id);
	}
	
	public static List<Lanche> obterTodos() {
		List<Lanche> lancheLista = new ArrayList<Lanche>(banco.values());
		return lancheLista;
	}
	
	public static List<Ingredientes> obterIngredientes() {
		return bancoIngredientes;
	}
	
	public static List<LancheIngrediente> obterIngredientes(Long id) {
		return banco.get(id).getLancheIngredientes();
	}
}
