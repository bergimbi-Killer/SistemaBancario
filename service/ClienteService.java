
package domain.service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.model.Cliente;
import domain.repository.ClienteRepository;

public class ClienteService {
 
    private ClienteRepository repositorio;
    
    public ClienteService (ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }
    public Cliente criarCliente (String Nome, long telefone, String BI) {
        Cliente cliente = new Cliente (Nome,telefone,BI);
        repositorio.salvar(cliente);
        return cliente;
    }
    public void imprimirDadosDoCliente(String BI) throws ClienteNaoEncontradoExcenption {
        Cliente cliente = repositorio.buscarPorBI(BI);
        System.out.println("Nome: " + cliente.getNomeCliente());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("BI: " + cliente.getBI());
    }
}
