package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ContaJaExisteException extends RuntimeException {

    private static final long serialVersionUID = -4866029807771642331L;

    public ContaJaExisteException() {
        super();
    }
}