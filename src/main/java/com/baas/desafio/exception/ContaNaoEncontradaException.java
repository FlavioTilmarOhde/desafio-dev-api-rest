package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContaNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1456187304927695345L;

    public ContaNaoEncontradaException() {
        super();
    }
}
