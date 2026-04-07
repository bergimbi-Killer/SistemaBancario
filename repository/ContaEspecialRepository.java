
package repository;

import domain.exception.ContaNaoEncontradaException;
import domain.model.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaEspecialRepository implements ContaRepository {

    List <Conta> contasEspecialRepository = new ArrayList <> ();
    private int ultimoIdGerado=0;
    @Override
    public void salvar(Conta conta) {
        contasEspecialRepository.add(conta);
    }

    @Override
    public Conta buscarPorID(int id) throws ContaNaoEncontradaException {
        for (Conta conta: contasEspecialRepository) {
            if (conta.getIdDaConta() == id) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException (id,"Conta não encontrada no sistema");
    }

    @Override
    public List<Conta> listarTodos() {
        return  new ArrayList <> (contasEspecialRepository);
    }

    @Override
    public int gerarNovoID() {
        return ++ultimoIdGerado;
    }
    
}
