
package domain.model;

import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import service.TipoDeConta;

public class ContaEspecial extends Conta {
    private double percengemDeAumento;
    
    public ContaEspecial ( int id, double saldo,Cliente titular, double percengemDeAumento) {
        super (id,saldo,TipoDeConta.ESPECIAL,titular);
        this.percengemDeAumento = percengemDeAumento;
        super.creditar((super.getSaldoDaConta() * this.percengemDeAumento) + super.getSaldoDaConta());
    }
    
    public double getLimiteDeSaldo() {
        return this.percengemDeAumento;
    }
    @Override
    public void sacarDinheiro (double valor) throws SaldoInferiorException, ValorInvalidoException {
        super.validarValor(valor);
        double novoSaldo = super.getSaldoDaConta()-valor;
        super.creditar(novoSaldo);
    }
}
