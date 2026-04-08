
package service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.exception.NumeroInvalido;
import domain.model.Cliente;
import repository.ClienteRepository;

public class ClienteService {
 
    private final ClienteRepository ClienteRepositorio;
    
    public ClienteService (ClienteRepository repository) {
        this.ClienteRepositorio = repository;
    }

    public Cliente criarCliente (String nome, long telefone, String bi) throws NumeroInvalido {

            if (telefone>900000000 ) {
                Cliente cliente = new Cliente (nome,telefone,bi);
                ClienteRepositorio.salvar(cliente);
                return cliente;
            }
            else {
                throw new NumeroInvalido("Numero Invalido", telefone);
            }
    }
    public void imprimirDadosDoCliente(String BI) throws ClienteNaoEncontradoExcenption {
        Cliente cliente = ClienteRepositorio.buscarPorBI(BI);
        System.out.println("====== DADOS DO CLIENTE ======");
        System.out.println("Nome: " + cliente.getNomeCliente());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("BI: " + cliente.getBI());
        System.out.println("===========================================");
    }
}
