
package controller;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.exception.NumeroInvalido;
import service.ClienteService;

public class ClienteControler {
    
    private final ClienteService  clienteService;
    
    public ClienteControler (ClienteService service) {
        this.clienteService = service;
    }
    public void criarCliente (String nome,long telefone, String bi) {
        try {
            clienteService.criarCliente(nome, telefone, bi);
            System.out.println("Cliente Cadastrado Com Sucesso");
        } catch (NumeroInvalido e) {
            System.out.println(e.getMensagem() + " " + e.getNumero());
        }

    }
    public void imprimirDadosDoCliente(String bi) {
        try {
            clienteService.imprimirDadosDoCliente(bi);
        }
        catch (ClienteNaoEncontradoExcenption e) {
            System.out.println(e.getMessage() + e.getBI());
        }
    }
}
