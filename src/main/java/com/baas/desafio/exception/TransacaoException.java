package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class TransacaoException extends RuntimeException {

    private static final long serialVersionUID = -8092053957639811273L;

    public TransacaoException() {
        super();
    }
}