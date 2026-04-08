
package service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.model.Cliente;
import domain.model.Conta;
import domain.model.ContaEspecial;
import repository.ClienteRepository;
import repository.ContaEspecialRepository;

public class ContaEspecialService {
    
    private final ContaEspecialRepository contaEspecialRepository;
    private final ClienteRepository clienteRepository;
    
    public ContaEspecialService (ContaEspecialRepository contaEspecialRepository, ClienteRepository ClienteRepository) {
        this.contaEspecialRepository = contaEspecialRepository;
        this.clienteRepository = ClienteRepository;
    }
    
    public Conta criarConta(Cliente titular, double saldo, double percentagemDeAumento, String biCliente) throws ClienteNaoEncontradoExcenption {
        int id = contaEspecialRepository.gerarNovoID();
        Cliente cliente = clienteRepository.buscarPorBI(biCliente);
        Conta conta = new ContaEspecial (id,saldo,cliente,percentagemDeAumento);
        contaEspecialRepository.salvar(conta);
        return conta;
    }
    public void depositar ();
    public void sacar();
    public void imprimirInformacoes();
}

