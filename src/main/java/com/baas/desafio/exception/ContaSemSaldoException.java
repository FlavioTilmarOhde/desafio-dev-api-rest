package com.baas.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ContaSemSaldoException extends RuntimeException  {

  private static final long serialVersionUID = -9188098316015193789L;

  public ContaSemSaldoException() {
      super();
  }

}
