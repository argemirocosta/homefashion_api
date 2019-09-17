package br.com.homefashion.api.services.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public ClienteNaoEncontradoException(String mensagen, Throwable causa){
        super(mensagen, causa);
    }

}
