package br.com.weberton.caixa2.modelo;

import br.com.weberton.caixa2.excecao.ValorInvalidoException;

/**
 * Classe Template de Conta
 * 
 * @author Weberton Silva
 *
 */
public abstract class Conta implements Tributavel{
	
	private String nome;
	private int agencia;
	private int numero;
	protected double saldo;

	public Conta(String nome, int agencia, int numero) {
		super();
		this.nome = nome;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	

	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void imprimir() {
		System.out.println(nome);
		System.out.println(agencia);
		System.out.println(saldo);

	}
	
	public abstract void atualizar (double valor);
	
	
	/**
	 * realiza um saque na conta, dado um valor passado. 
	 * 
	 * @param valor: valor a ser sacado
	 */
	public void sacar(double valor){
		this.saldo -= valor;
	}
	
	public void depositar(double valor) throws ValorInvalidoException{		
		if(valor < 0){
			throw new ValorInvalidoException(valor);
		}else{
			this.saldo += valor;	
		}		
	}	
	
	public double calcularTributos() {
		return this.getSaldo() * 0.01;		
	}

	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", numero=" + numero + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia != other.agencia)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	
	
	
}
