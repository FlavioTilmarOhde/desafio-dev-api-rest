package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransacaoException.class)
    protected ResponseEntity<Object> handleException (TransacaoException ex, WebRequest request) {
        ResponseHandler response = new ResponseHandler("TransacaoException", "Erro ao gravar transação.");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContaNaoEncontradaException.class)
    protected ResponseEntity<Object> handleException (ContaNaoEncontradaException ex, WebRequest request) {
        ResponseHandler response = new ResponseHandler("ContaNaoEncontradaException", "Conta não existente.");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContaJaExisteException.class)
    protected ResponseEntity<Object> handleException (ContaJaExisteException ex, WebRequest request) {
        ResponseHandler response = new ResponseHandler("ContaJaExisteException", "Conta já existente.");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContaSemSaldoException.class)
    protected ResponseEntity<Object> handleException (ContaSemSaldoException ex, WebRequest request) {
        ResponseHandler response = new ResponseHandler("ContaSemSaldoException", "Conta sem saldo.");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContaBloqueadaException.class)
    protected ResponseEntity<Object> handleException (ContaBloqueadaException ex, WebRequest request) {
        ResponseHandler response = new ResponseHandler("ContaBloqueadaException", "Conta bloqueada.");

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

}