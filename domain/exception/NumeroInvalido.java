package domain.exception;

public class NumeroInvalido extends Exception {
    long numero;
    String mensagem;
    public NumeroInvalido(String mensagem, long numero) {
        this.mensagem = mensagem;
        this.numero =numero;
    }

    public long getNumero() {
        return numero;
    }

    public String getMensagem() {
        return mensagem;
    }
}

