/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.service;

import domain.model.Conta;
import domain.model.ContaEspecial;

/**
 *
 * @author Bernardo Gimbi
 
 */
public class ContaService {
    
    public void ImprimirDadosDaConta(Conta conta) {
        System.out.println("Saldo Bancario: " + conta.getSaldoDaConta());
        System.out.println("Numero Da Conta:" + conta.getIdDaConta());
        System.out.println ("Tipo De Conta:" + conta.getTipoDeConta());
        if (conta instanceof ContaEspecial ) {
            System.out.println("Limite de valor acrescido: "  + ((ContaEspecial) conta).getLimiteDeSaldo() + "%");
        }
    }
    
    }
    

