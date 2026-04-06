
package domain.exception;

public class SaldoInferiorException extends Exception {
    private double ValorDeSaque;
    private String mensagem;
    
    public SaldoInferiorException(double ValorDeSaque, String mensagem) {
        this.ValorDeSaque = ValorDeSaque;
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
    public double getValor(){
        return this.ValorDeSaque;
    }
}
