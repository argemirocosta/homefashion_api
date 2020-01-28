package br.com.homefashion.api.services.exceptions;

import static br.com.homefashion.api.shared.Mensagens.CLIENTE_NAO_ENCONTRADO;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(){
        super(CLIENTE_NAO_ENCONTRADO);
    }

    public ClienteNaoEncontradoException(String mensagen, Throwable causa){
        super(mensagen, causa);
    }

}
