package br.com.weberton.caixa2.modelo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.weberton.caixa2.excecao.ValorInvalidoException;
import br.com.weberton.caixa2.modelo.Conta;
import br.com.weberton.caixa2.modelo.ContaCorrente;

public class ContaTest {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
				
		Conta Mau = new ContaCorrente("Mauricio", 1111, 00001);		
		Conta Ze = new ContaCorrente("José", 1111, 00001);		
	    System.out.println(Mau.equals(Ze));
	}
	
	Conta objetoConta;

	@Test
	public static void testDepositar() {
		
		Conta objetoConta = new ContaCorrente("Mauricio", 1111, 00001);
		try{
			objetoConta.depositar(-1);	
		}catch(ValorInvalidoException e){
			System.out.println(e.getMessage());
		}	
		
		assertEquals(0, objetoConta.getSaldo(), 0.1);
	}

}
