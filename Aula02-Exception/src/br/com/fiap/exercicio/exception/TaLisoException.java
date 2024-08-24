package br.com.fiap.exercicio.exception;

public class TaLisoException extends Exception {

    public TaLisoException(String mensagem){
        super(mensagem);
    }

    public TaLisoException(double valor){
        super("Saldo insuficiente, valor disponível: " + valor);
    }

    public TaLisoException(){
        super("Saldo insuficiente");
    }

}
