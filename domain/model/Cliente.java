
package domain.model;


import domain.exception.NumeroInvalido;

public class Cliente {
    private String nomeCliente;
    private long telefone;
    private String BI;
    
    public Cliente (String nome, long numero, String BI) {
        this.nomeCliente = nome;
        this.BI = BI;
        this.telefone = numero;
    }
    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }
    /*public void setBI (String bi) {
        this.BI = bi;
    }*/
    public void setTelefone (long numero) throws NumeroInvalido {
        if (numero>900000000 ) {
            this.telefone = numero;
        }
        else {
           throw new NumeroInvalido("Numero Invalido",numero);
        }
    }
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    public long getTelefone() {
        return this.telefone;
    }
    public String getBI() {
        return this.BI;
    }
}


