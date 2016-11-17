package br.com.weberton.caixa2.modelo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.weberton.caixa2.excecao.ValorInvalidoException;
import br.com.weberton.caixa2.modelo.Conta;
import br.com.weberton.caixa2.modelo.ContaCorrente;

public class ContaTest {
	
	Conta objetoConta;

	@Test
	public void testDepositar() {
		
		Conta objetoConta = new ContaCorrente("Mauricio", 1111, 00001);
		try{
			objetoConta.depositar(-1);	
		}catch(ValorInvalidoException e){
			System.out.println(e.getMessage());
		}	
		
		assertEquals(0, objetoConta.getSaldo(), 0.1);
	}

}
