package br.com.homefashion.api.services.exceptions;

import static br.com.homefashion.api.shared.Mensagens.PAGAMENTO_NAO_ENCONTRADO;

public class PagamentoNaoEncontradoException extends RuntimeException {

    public PagamentoNaoEncontradoException(){
        super(PAGAMENTO_NAO_ENCONTRADO);
    }

    public PagamentoNaoEncontradoException(String mensagen, Throwable causa){
        super(mensagen, causa);
    }

}
