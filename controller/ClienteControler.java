
package controller;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.service.ClienteService;

public class ClienteControler {
    
    ClienteService service;
    
    public ClienteControler (ClienteService service) {
        this.service = service;
    }
    public void criarCliente (String Nome,long telefone, String BI) {
        service.criarCliente(Nome, telefone, BI);
        System.out.println("Cliente Criada Com Sucesso");
        }
    public void imprimirDadosDoCliente(String BI) {
        try {
            service.imprimirDadosDoCliente(BI);
        }
        catch (ClienteNaoEncontradoExcenption e) {
            System.out.println(e.getMessage() + e.getBI());
        }
    }
}
