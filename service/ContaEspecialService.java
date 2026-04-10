
package service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.model.Cliente;
import domain.model.Conta;
import domain.model.ContaEspecial;
import repository.ClienteRepository;
import repository.ContasRepository;

public class ContaEspecialService {
    
    private final ContasRepository contasRepository;
    private final ClienteRepository clienteRepository;
    
    public ContaEspecialService ( ContasRepository contaRepository, ClienteRepository ClienteRepository) {
        this.contasRepository = contaRepository;
        this.clienteRepository = ClienteRepository;
    }
    
    public Conta criarConta(Cliente titular, double saldo, double percentagemDeAumento, String biCliente) throws ClienteNaoEncontradoExcenption {
        int id = contasRepository.gerarNovoID();
        Cliente cliente = clienteRepository.buscarPorBI(biCliente);
        Conta conta = new ContaEspecial (id,saldo,cliente,percentagemDeAumento);
        contasRepository.salvar(conta);
        return conta;
    }
    /*public void depositar ();
    public void sacar();
    public void imprimirInformacoes();*/
}

