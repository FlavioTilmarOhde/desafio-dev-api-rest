package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ContaBloqueadaException extends RuntimeException {

    private static final long serialVersionUID = 5196371413627556531L;

    public ContaBloqueadaException() {
        super();
    }
}
