
package domain.model;

import domain.exception.SaldoInferiorException;

public class ContaEspecial extends Conta {
    private double percenAumento;
    
    public ContaEspecial (int ID, double Saldo, String TipoConta, double Limite) {
        super (ID,Saldo, TipoConta);
        this.percenAumento = Limite;
        super.setSaldoDaConta((super.getSaldoDaConta() * this.percenAumento) + super.getSaldoDaConta());
    }
    public void setLimiteDeSaldo(double limite) {
        this.percenAumento= limite;
    }
    public double getLimiteDeSaldo() {
        return this.percenAumento;
    }
    @Override
    public void SacarDinheiro (double Valor) throws SaldoInferiorException{
        if (super.getSaldoDaConta() > Valor) {
            super.setSaldoDaConta((super.getSaldoDaConta()-Valor));
            System.out.println("Sucesso");
        }
        String mensagem = "O teu saldo bancario e inferior ao valor de levantamento";
        throw new SaldoInferiorException (Valor,mensagem);
    }
   
}
