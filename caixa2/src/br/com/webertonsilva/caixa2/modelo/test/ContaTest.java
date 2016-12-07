package br.com.webertonsilva.caixa2.modelo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import br.com.webertonsilva.caixa2.excecao.ValorInvalidoException;
import br.com.webertonsilva.caixa2.modelo.Conta;
import br.com.webertonsilva.caixa2.modelo.ContaCorrente;
import br.com.webertonsilva.caixa2.modelo.ContaPoupanca;

public class ContaTest {
	
	@Test
	public void testEqualEHashCode() {	
		
		/*
		 * O HashSet não adiciona elementos repetidos
		 * nesse caso o que foi definido no HashCode (Número da Conta)
		 */
		Set<Conta> listaContas = new HashSet<>();
		
		Conta c1 = new ContaCorrente("Jair", 1111, 00001);
		Conta c2 = new ContaCorrente("Antônio", 2222, 00001);
		Conta c3 = new ContaCorrente("Barbosa", 3333, 00001);
		Conta c4 = new ContaCorrente("Carvalho", 4444, 00001);
		Conta c5 = new ContaCorrente("Daniel", 5555, 00001);
		
		Conta conta[] = new Conta[5];
		conta[0]=c1;
		conta[1]=c2;
		conta[2]=c3;
		conta[3]=c4;
		conta[4]=c5;	
		
		for (int i = 0; i < 5; i++) {
			listaContas.add(conta[i]);
		}		
		assertEquals(1, listaContas.size());
	}
	
	

	@Test
	public void testMapa() {
		
        Conta c1 = new ContaCorrente("Jair", 1111, 00001);
        Conta c2 = new ContaCorrente("Sérgio", 2222, 00002);
        
        try {
			c1.depositar(10000);
			c2.depositar(3000);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // cria o mapa
        Map<String, Conta> mapaDeContas = new HashMap<String, Conta>();        

        // adiciona duas chaves e seus valores
        mapaDeContas.put("diretor", c1);
        mapaDeContas.put("gerente", c2);

        // qual a conta do diretor?
        Conta contaDoDiretor = mapaDeContas.get("diretor");

        assertEquals(10000, contaDoDiretor.getSaldo(), 0.5);

	}
	
	
	@Test
	public void testOrdenacao() {
		
		List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
	
		ContaPoupanca Mau = new ContaPoupanca("Mauricio", 1111, 00002);		
		ContaPoupanca Ze = new ContaPoupanca("Jose", 1111, 00001);
		
		contas.add(Mau);
		contas.add(Ze);		
		
		assertEquals("Mauricio", contas.get(0).getNome());
		
		Collections.sort(contas);
		
		assertEquals("Jose", contas.get(0).getNome());

	}
	
	
	@Test
	public void testSaldoRandomico() {
		
		Random gerador = new Random();
		
		ContaPoupanca mau = new ContaPoupanca("Mauricio", 1111, 00002);		
		
		try {
			mau.depositar(gerador.nextInt(1000));
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(mau.getSaldo() > 0);

	}
	
	
	
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
