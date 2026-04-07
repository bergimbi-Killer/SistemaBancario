
package repository;
import domain.exception.ContaNaoEncontradaException;
import domain.model.Conta;
import java.util.*;


public class ContaPoupancaRepository implements ContaRepository {

    List <Conta> contasPoupaca = new ArrayList <> ();
    private int ultimoIdGerado=0;
    @Override
    public void salvar(Conta conta) {
        contasPoupaca.add(conta);
    }
    @Override
    public Conta buscarPorID (int id) throws ContaNaoEncontradaException {
        for (Conta c: contasPoupaca) {
            if (c.getIdDaConta() == id) {
                return c;                
            }
        }
            throw new ContaNaoEncontradaException(id, "Conta não encontrada");
        }
    @Override
    public List<Conta> listarTodos() {
        return new ArrayList <> (contasPoupaca);
    }
    @Override
    public int gerarNovoID() {
       return ++ultimoIdGerado;  
    }
}
