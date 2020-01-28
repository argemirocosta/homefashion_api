package br.com.homefashion.api.services.exceptions;

import static br.com.homefashion.api.shared.Mensagens.USUARIO_NAO_ENCONTRADO;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(){
        super(USUARIO_NAO_ENCONTRADO);
    }

    public UsuarioNaoEncontradoException(String mensagen, Throwable causa){
        super(mensagen, causa);
    }

}
