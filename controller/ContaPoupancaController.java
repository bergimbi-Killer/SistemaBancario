
package controller;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.exception.ContaNaoEncontradaException;
import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import domain.model.Conta;
import domain.service.ContaPoupancaService;

public class ContaPoupancaController {
    
    private ContaPoupancaService contaPoupancaService;
    
    public ContaPoupancaController (ContaPoupancaService contaPoupancaService) {
        this.contaPoupancaService = contaPoupancaService;
    }
    public void criarConta (double saldo,String biCliente)  {
        try {
            Conta contaPoupanca = contaPoupancaService.criarConta(saldo,biCliente);
            System.out.println("Conta criada com sucesso."); 
        }
        catch ( ClienteNaoEncontradoExcenption e) {
            System.out.println(e.getMessage() + " " + e.getBI());
        } 
    }
    public void imprimirDadosDaConta(int Id) {
        try {   
            contaPoupancaService.imprimirDadosDaConta(Id);
        }
        catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage() + " " + e.getID());   
        }   
    }
    public void sacarDinheiro (int id, double valor)  {
        try {
            contaPoupancaService.sacarDinheiro(valor, id);
            System.out.println("Saque de " + valor + " realizado com sucesso." + "ID da conta: " + id);
        } catch (SaldoInferiorException e) {
            System.out.println(e.getMessage() + ". Valor: " + e.getValor());
        }
        catch (ContaNaoEncontradaException e){
            System.out.println(e.getMessage() + " ID da conta: " + e.getID());
        }
        catch(ValorInvalidoException e) {
            System.out.println(e.getMessage() + ". Valor: " + e.getValor());
        }
    }
    public void consultar (int id)  {
        try {
            double saldoAtual = contaPoupancaService.consultar(id);
            System.out.println("Saldo atual: " + saldoAtual);
        }
        catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage() + " " + e.getID());
        }
    }
    public void depositar (int id, double valor)  {
        try {
            contaPoupancaService.depositar(id, valor);
        }
        catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage() + " " + e.getID());
        }
        catch (ValorInvalidoException e) {
            System.out.println(e.getMessage() + e.getValor());
        }
        
    }
    /* public void atribuirTitular (String BI, int ID) {
        try {
            CP_Service.atribuirTitular(BI, ID);
        }
        catch (ClienteNaoEncontradoExcenption e) {
            System.out.println(e.getMessage() + " " + e.getBI());
        }
        catch (ContaNaoEncontradaException e) {
            System.out.println (e.getMessage() + " " + e.getID());
        }
    }*/
}
