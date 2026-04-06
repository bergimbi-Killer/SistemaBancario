
package domain.model;

import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import domain.service.TipoDeConta;

public abstract class Conta {
    
    private final int idDaConta;
    private double saldoDaConta;
    TipoDeConta tipoDeConta;
    private Cliente cliente;
    
    public Conta (int id, double saldo, TipoDeConta tipoConta, Cliente titular) {
        this.idDaConta = id;
        this.saldoDaConta = saldo;
        this.tipoDeConta = tipoConta;
        this.cliente=titular;
    }
    //=============================================
   
   
    public void setCliente (Cliente titular){
        this.cliente = titular;
    }
    public int getIdDaConta () {
        return this.idDaConta;
    }
    public double getSaldoDaConta() {
        return this.saldoDaConta;
    }
    public TipoDeConta getTipoDeConta () {
        return this.tipoDeConta;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    //==============================================
    
    public abstract void sacarDinheiro (double valor) throws SaldoInferiorException, ValorInvalidoException ;
    /*public double ConsultarSaldo(){
        return this.SaldoDaConta;
    }*/
    public void depositar (double valor) throws ValorInvalidoException, SaldoInferiorException {
        this.validarValor(valor);
        this.creditar(valor);
    } 
    protected void creditar (double valor) {
        this.saldoDaConta=+valor;
    }
    protected void debitar (double valor) {
        this.saldoDaConta=-valor;
    }
   protected void validarValor (double valor) throws ValorInvalidoException, SaldoInferiorException {
       if (valor<=0) {
           throw new ValorInvalidoException ("Valor invalido",valor);
       }
       if (this.saldoDaConta < valor) {
           throw new SaldoInferiorException (valor,"Nao autorizado");
       }
   }
}

