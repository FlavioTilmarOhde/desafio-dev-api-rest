package com.baas.desafio.service;

import java.util.Optional;

import com.baas.desafio.entity.Conta;
import com.baas.desafio.repository.ContaRepository;
import com.baas.desafio.repository.TransacaoRepository;
import com.baas.desafio.exception.ContaBloqueadaException;
import com.baas.desafio.exception.ContaSemSaldoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    public Conta getConta(long idConta) {

        Optional<Conta> conta = contaRepository.findById(idConta);

        return conta.get();

    }

    public Conta bloqueioConta(Conta conta) {

        conta.setFlagAtivo(false);

        return contaRepository.save(conta);

    }

    public void verificaContaAtiva(Conta conta) {
        if(!conta.isFlagAtivo()) {
            throw new ContaBloqueadaException();
        }
    }

    public void verificaContaTemSaldo(Double vlrAtual, Double vlrTransacao) {
        if (vlrAtual+vlrTransacao<0) {
            throw new ContaSemSaldoException();
        }
    }
}