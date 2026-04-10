
package service;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.exception.ContaNaoEncontradaException;
import domain.exception.SaldoInferiorException;
import domain.exception.ValorInvalidoException;
import domain.model.Cliente;
import domain.model.Conta;
import domain.model.ContaEspecial;
import domain.model.ContaPoupanca;
import repository.ClienteRepository;
import repository.ContaRepository;
import repository.ContasRepository;

public class ContaPoupancaService {
   
   private final ContasRepository contaRepository;
   private final ClienteRepository clienteRepository;
   public ContaPoupancaService (ContasRepository contaRepository,ClienteRepository clienteRepository){
       this.contaRepository = contaRepository;
       this.clienteRepository = clienteRepository;
   }
   public Conta criarConta (double saldoInicial, String biCliente) throws ClienteNaoEncontradoExcenption {
       Cliente titular = clienteRepository.buscarPorBI(biCliente);
       int id = contaRepository.gerarNovoID();
       Conta contaPoupanca = new ContaPoupanca (id,saldoInicial,titular);
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
    public void tranferirDinheiro (ContaPoupanca contaAtual, Conta contaDestino, double valor) throws SaldoInferiorException, ValorInvalidoException {
       Conta conta = null;
       if (contaDestino instanceof ContaPoupanca) {
           ContaPoupanca novaContaDestino = (ContaPoupanca) contaDestino;
           conta = novaContaDestino;
       }
       if (contaDestino instanceof ContaEspecial) {
           ContaEspecial novaContaDestino = (ContaEspecial) contaDestino;
           conta = novaContaDestino;
       }
       contaAtual.sacarDinheiro(valor);
       conta.depositar(valor);
       contaRepository.salvar(contaAtual);
       contaRepository.salvar(conta);


    }
}

