package domain.exception;

public class ValorInvalidoException extends Exception {
    private String mensagem;
    private double valor;
    
    public ValorInvalidoException (String mensagem, double valor){
        this.mensagem=mensagem;
        this.valor=valor;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
    public double getValor(){
        return this.valor;
    }
}
