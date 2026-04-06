
package domain.exception;

public class ClienteNaoEncontradoExcenption extends Exception {
    private String mensagem,BI;
    
    public ClienteNaoEncontradoExcenption (String mensagem, String BI) {
        this.BI = BI;
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
    public String getBI() {
        return this.BI;
    }
}
