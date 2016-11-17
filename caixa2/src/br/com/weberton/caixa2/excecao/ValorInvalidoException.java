package br.com.weberton.caixa2.excecao;

public class ValorInvalidoException extends Exception{
	
	
	public ValorInvalidoException(Double valor) {
		super("Valor Inválido " + valor);
	}
}
