
package domain.model;

import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import domain.service.TipoDeConta;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca (int id, double saldo, Cliente titular) {
        super (id, saldo, TipoDeConta.POUPANCA, titular);
    }

    @Override
    public void sacarDinheiro(double valor) throws SaldoInferiorException, ValorInvalidoException {
        super.validarValor(valor);
        double novoSaldo = super.getSaldoDaConta()-valor;
        super.debitar(novoSaldo);
    }
}
