package com.baas.desafio.controller;
import com.baas.desafio.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.baas.desafio.entity.Transacao;

import java.util.List;

@RestController
@RequestMapping("/transacao")

public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping("/deposito")
    public ResponseEntity<Transacao> deposito(@RequestBody Transacao transacao) {

        return new ResponseEntity<>(transacaoService.depostio(transacao), HttpStatus.CREATED);
    }

    @PostMapping("/saque")
    public ResponseEntity<Transacao> saque(@RequestBody Transacao transacao) {

        return new ResponseEntity<>(transacaoService.saque(transacao), HttpStatus.CREATED);
    }

    @GetMapping("/extrato/{idConta}")
    public ResponseEntity<List<Transacao>> getExtrato(@PathVariable("idConta") Long idConta) {

        return new ResponseEntity<>(transacaoService.extratotransacoes(idConta), HttpStatus.OK);

    }
}
