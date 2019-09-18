package br.com.homefashion.api.handler;

import br.com.homefashion.api.domain.DetalhesErro;
import br.com.homefashion.api.services.exceptions.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException
            (ClienteNaoEncontradoException e, HttpServletRequest request) {

        DetalhesErro detalhesErro = new DetalhesErro(404, "Não encontrado!", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);

    }
}
