
package repository;

import domain.exception.ContaNaoEncontradaException;
import domain.model.Conta;
import java.util.*;


public interface ContaRepository {
    void salvar(Conta conta);
    Conta buscarPorID (int ID) throws ContaNaoEncontradaException;
    List <Conta> listarTodos();
    int gerarNovoID();
}
