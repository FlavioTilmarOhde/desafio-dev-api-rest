package com.baas.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baas.desafio.entity.Conta;
import com.baas.desafio.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping()
    public ResponseEntity<Conta> createConta(@RequestBody Conta conta) {
          return new ResponseEntity<>(contaService.createConta(conta), HttpStatus.CREATED);
    }

    @GetMapping("/{idConta}/saldo")
    public ResponseEntity<Conta> getSaldo(@PathVariable("idConta") long idConta) {

       return new ResponseEntity<>(contaService.getSaldo(idConta), HttpStatus.OK);
    }

    @PutMapping("/{idConta}/bloqueia")
    public ResponseEntity<Boolean> bloqueiaConta(@PathVariable("idConta") long idConta) {

       return new ResponseEntity<>(contaService.bloqueiaConta(idConta), HttpStatus.CREATED);
    }
}



