package br.com.finchsolucoes.lanchonete;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.finchsolucoes.lanchonete.dao.LanchesDAO;
import br.com.finchsolucoes.lanchonete.modelo.Ingredientes;
import br.com.finchsolucoes.lanchonete.modelo.Lanche;
import br.com.finchsolucoes.lanchonete.modelo.LancheIngrediente;
import br.com.finchsolucoes.lanchonete.servico.LancheServico;


public class LancheServicoTest {
	
	@Test
	public void deveTestarCalculaValorXBacon() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(LanchesDAO.busca(1l));
		Assert.assertEquals(5.5, lanche.getValor());
	}
	
	@Test
	public void deveTestarCalculaValorXBurguer() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(LanchesDAO.busca(2l));
		Assert.assertEquals(3.5, lanche.getValor());
	}

	@Test
	public void deveTestarCalculaValorXEgg() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(LanchesDAO.busca(3l));
		Assert.assertEquals(4.3, lanche.getValor());
	}

	@Test
	public void deveTestarCalculaValorXEggBacon() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(LanchesDAO.busca(4l));
		Assert.assertEquals(6.3, lanche.getValor());
	}
	
	@Test
	public void deveTestarRegraPromocoesLight() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(umLanchePromocaoLight());
		lancheServico.verificaLight(lanche);
		Assert.assertEquals(3.51, lanche.getValor());
	}
	
	@Test
	public void deveTestarRegraPromocaoMuitoQueijo() {
		LancheServico lancheServico = new LancheServico();
		Lanche lanche = lancheServico.calculaValorLanche(umLancheComMuitoQueijo());
		lancheServico.verificaMuitoQueijo(lanche);
		Assert.assertEquals(5.4, lanche.getValor());
	}
	
	public Lanche umLanchePromocaoLight() {
		Ingredientes alface     = new Ingredientes(1l,"Alface",0.40);		
		Ingredientes hamburguer = new Ingredientes(3l,"Hambúrguer de carne",2);
		Ingredientes queijo     = new Ingredientes(5l,"Queijo",1.50);
		
		Lanche lanche = new Lanche();
		lanche.setLancheIngredientes(Arrays.asList(new LancheIngrediente(1l, lanche, alface, 1),
                new LancheIngrediente(2l, lanche, hamburguer, 1),
                new LancheIngrediente(3l, lanche, queijo, 1)));

		return lanche;
	}
	
	public Lanche umLancheComMuitoQueijo() {
		
		Ingredientes alface     = new Ingredientes(1l,"Alface",0.40);		
		Ingredientes hamburguer = new Ingredientes(3l,"Hambúrguer de carne",2);
		Ingredientes queijo     = new Ingredientes(5l,"Queijo",1.50);
		
		Lanche lanche = new Lanche();
		lanche.setLancheIngredientes(Arrays.asList(new LancheIngrediente(1l, lanche, alface, 1),
                new LancheIngrediente(2l, lanche, hamburguer, 1),
                new LancheIngrediente(3l, lanche, queijo, 3)));

		return lanche;
	}

}
