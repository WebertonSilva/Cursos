package br.com.webertonsilva.caixa2.modelo;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{

	public ContaPoupanca(String nome, int agencia, int numero) {
		super(nome, agencia, numero);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void atualizar(double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(ContaPoupanca outraConta) {
		
		if(this.getNome().compareTo(outraConta.getNome()) < 0){
			return -1;		
		}
		
		if(this.getNome().compareTo(outraConta.getNome()) > 0){
			return 1;
		}
		
		return 0;
	}

}
