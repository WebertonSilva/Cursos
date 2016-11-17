package br.com.weberton.caixa2.servico.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.weberton.caixa2.excecao.ValorInvalidoException;
import br.com.weberton.caixa2.modelo.ContaCorrente;
import br.com.weberton.caixa2.modelo.SeguroVida;
import br.com.weberton.caixa2.servico.GerenciadorDeImpostoDeRenda;

public class GerenciadorDeImpostoDeRendaTest {

	@Test
	public void testAdiciona() {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
		
		SeguroVida sv = new SeguroVida();
		gerenciador.adiciona(sv);
		
		ContaCorrente cc = new ContaCorrente("José da Silva", 444, 1000);
		try {
			cc.depositar(1000.0);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gerenciador.adiciona(cc);		
		
		assertEquals(52.0, gerenciador.getTotal(), 0.1);
		
		System.out.printf("O saldo é: %.2f", gerenciador.getTotal());		
	}
}
