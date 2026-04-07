
package service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.exception.ContaNaoEncontradaException;
import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import domain.model.Cliente;
import domain.model.Conta;
import domain.model.ContaPoupanca;
import domain.repository.ClienteRepository;
import domain.repository.ContaRepository;

public class ContaPoupancaService {
   
   private final ContaRepository contaRepository;
   private final ClienteRepository clienteRepository;
   public ContaPoupancaService (ContaRepository contaRepository,ClienteRepository clienteRepository){
       this.contaRepository = contaRepository;
       this.clienteRepository = clienteRepository;
   }
   public Conta criarConta (double saldoInicial, String biCliente) throws ClienteNaoEncontradoExcenption {
       Cliente titular = clienteRepository.buscarPorBI(biCliente);
       int novoId = contaRepository.gerarNovoID();
       Conta contaPoupanca = new ContaPoupanca (novoId,saldoInicial,titular);
       contaRepository.salvar(contaPoupanca);
       return contaPoupanca;
   }
    public void imprimirDadosDaConta(int ID) throws ContaNaoEncontradaException {
        Conta conta = contaRepository.buscarPorID(ID);//lança exceção
        System.out.println("===== EXTRATO DE CONTA =====");
        System.out.println("ID: " + conta.getIdDaConta());
        System.out.println("Tipo De Conta: " + conta.getTipoDeConta());
        System.out.println("Titular: " + conta.getCliente().getNomeCliente());
        System.out.println("Saldo: " + conta.getSaldoDaConta());
        System.out.println("======================================");
    }
    
    public void sacarDinheiro(double valor, int ID) throws SaldoInferiorException, ContaNaoEncontradaException, ValorInvalidoException {
        Conta conta = contaRepository.buscarPorID(ID);
        conta.sacarDinheiro(valor);
        contaRepository.salvar(conta);
                
    }
    public double consultar(int ID) throws ContaNaoEncontradaException {
        Conta conta = contaRepository.buscarPorID(ID);
        return conta.getSaldoDaConta();
    }
    public void depositar (int ID, double valor) throws ContaNaoEncontradaException, ValorInvalidoException, SaldoInferiorException {
        Conta conta = contaRepository.buscarPorID(ID);
        conta.depositar(valor);
        contaRepository.salvar(conta);
    }
    /*public void atribuirTitular (String BI, int ID) throws ClienteNaoEncontradoExcenption, ContaNaoEncontradaException {
        Cliente cliente = clirepository.buscarPorBI(BI);
        Conta conta = repository.buscarPorID(ID);
        conta.atribuirTitular(cliente);
        repository.salvar(conta);
    }*/
}

