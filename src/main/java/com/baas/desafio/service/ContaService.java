package com.baas.desafio.service;

import java.util.Optional;

import com.baas.desafio.entity.Conta;
import com.baas.desafio.repository.ContaRepository;
import com.baas.desafio.repository.TransacaoRepository;
import com.baas.desafio.exception.ContaBloqueadaException;
import com.baas.desafio.exception.ContaSemSaldoException;
import com.baas.desafio.exception.ContaJaExisteException;
import com.baas.desafio.exception.ContaNaoEncontradaException;

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

        if (conta.isEmpty())
                throw new ContaNaoEncontradaException();

        return conta.get();
    }

    public Conta getSaldo(long idConta){

       return getConta(idConta);

    }

    public Conta createConta(Conta conta) {

        if (contaRepository.findById(conta.getIdConta()).isPresent()) {
            throw new ContaJaExisteException();
        }

        return contaRepository.save(conta);
    }

    public Boolean bloqueiaConta(long idConta) {

        Conta _conta = getConta(idConta);
        _conta.setFlagAtivo(false);
        contaRepository.save(_conta);

        return true;

    }

    public void verificaContaAtiva(Conta _conta) {

        if(!_conta.isFlagAtivo()) {
            throw new ContaBloqueadaException();
        }
    }

    public void verificaContaTemSaldo(Double vlrAtual, Double vlrTransacao) {
        if (vlrAtual+vlrTransacao<0) {
            throw new ContaSemSaldoException();
        }
    }
}