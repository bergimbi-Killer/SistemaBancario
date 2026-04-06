
package domain.repository;

import domain.exception.ClienteNaoEncontradoExcenption;
import domain.model.Cliente;
import java.util.List;
import java.util.*;

public class ClienteRepository  {

    List <Cliente> Clientes = new ArrayList ();
    
    public void salvar(Cliente cliente) {
        Clientes.add(cliente);
    }
    public Cliente buscarPorBI(String BI) throws ClienteNaoEncontradoExcenption {
        for(Cliente c:Clientes){
            if (c.getBI().equals(BI)) {
                return c;
            }
        }
        throw new ClienteNaoEncontradoExcenption ("Cliente não encontrado", BI);
    }

    
    public List<Cliente> listarTodos() {
        return new ArrayList <> (Clientes);
    } 
}
