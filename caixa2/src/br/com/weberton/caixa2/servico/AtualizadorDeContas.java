package br.com.weberton.caixa2.servico;

import br.com.weberton.caixa2.modelo.Conta;

class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public void roda(Conta c) {
        // aqui você imprime o saldo anterior
        System.out.println(c.getSaldo());

        // atualiza a conta com a taxa selic,
        c.atualizar(this.selic);

        // e depois imprime o saldo final
        System.out.println(c.getSaldo());

        // lembrando de somar o saldo final ao atributo saldoTotal
        saldoTotal += c.getSaldo();
    }

    // outros métodos, colocar o getter para saldoTotal!
    public double getSaldoTotal(){
    	return this.saldoTotal;
    }
}