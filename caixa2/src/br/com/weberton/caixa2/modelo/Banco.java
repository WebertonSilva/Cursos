package br.com.weberton.caixa2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	
	private List<Conta> contas = new ArrayList<Conta>();
	
	Map<String, Conta> clientes = new HashMap<>();
	
	void adicionarContas(Conta c){	
		contas.add(c);
		clientes.put(c.getNome(), c);
	}
	
	Conta getConta(int x){
		return this.contas.get(x);	
	}
	
	int pegarQuantidadeDeContas(){
		return contas.size();
	}
	
	Conta buscarPorNome(String nome){
		return clientes.get(nome);			
	}
}
