package br.com.webertonsilva.caixa2.modelo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.webertonsilva.caixa2.excecao.ValorInvalidoException;
import br.com.webertonsilva.caixa2.modelo.ContaCorrente;
import br.com.webertonsilva.caixa2.modelo.Tributavel;

public class TributavelTest {

	
	@Test
	public void testCalcularTributos() {
		
		ContaCorrente cc = new ContaCorrente("João da Silva", 123, 1000);
		System.out.println(cc.calcularTributos());
		
		try {
			cc.depositar(100.0);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// testando polimorfismo:
		Tributavel t = cc;	
		
		assertEquals(1.0, t.calcularTributos(), 0.1);		
		System.out.println(t.calcularTributos());		

	}
}
