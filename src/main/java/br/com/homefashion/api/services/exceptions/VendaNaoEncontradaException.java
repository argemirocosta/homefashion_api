package br.com.homefashion.api.services.exceptions;

import static br.com.homefashion.api.shared.Mensagens.VENDA_NAO_ENCONTRADA;

public class VendaNaoEncontradaException extends RuntimeException {

    public VendaNaoEncontradaException(){
        super(VENDA_NAO_ENCONTRADA);
    }

    public VendaNaoEncontradaException(String mensagen, Throwable causa){
        super(mensagen, causa);
    }

}
