package br.com.webertonsilva.caixa2.servico;

import br.com.webertonsilva.caixa2.modelo.Tributavel;

public class GerenciadorDeImpostoDeRenda {
	private static double TOTAL = 0;
	
	public void adiciona(Tributavel t){
		System.out.println("Adiciona tributável" + t);
		this.TOTAL += t.calcularTributos();
	}
	
	public double getTotal(){
		return this.TOTAL;
	}

}
