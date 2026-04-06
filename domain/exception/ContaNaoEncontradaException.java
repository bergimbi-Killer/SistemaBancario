
package domain.exception;

public class ContaNaoEncontradaException extends Exception {
    private String mensagem;
    private int ID;
    
    public ContaNaoEncontradaException (int ID, String mensagem) {
        this.ID = ID;
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
    public int getID(){
        return this.ID;
    }
}
