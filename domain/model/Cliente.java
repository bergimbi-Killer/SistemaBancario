
package domain.model;


import domain.exception.NumeroInvalido;

public class Cliente {
    private String nomeCliente;
    private long telefone;
    private final String bi;
    
    public Cliente (String nome, long numero, String bi) {
        this.nomeCliente = nome;
        this.bi = bi;
        this.telefone = numero;
    }
    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    public long getTelefone() {
        return this.telefone;
    }
    public String getBI() {
        return this.bi;
    }
}


