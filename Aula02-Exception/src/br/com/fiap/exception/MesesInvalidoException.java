package br.com.fiap.exception;

public class MesesInvalidoException extends Exception {

    public MesesInvalidoException(String mensagem){
        super(mensagem);
    }

    public MesesInvalidoException(){
        super("O mês deve estar entre 1 e 12");
    }

}
