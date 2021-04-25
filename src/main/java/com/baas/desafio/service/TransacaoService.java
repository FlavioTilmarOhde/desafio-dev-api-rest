package com.baas.desafio.service;

import java.util.List;
import java.util.Optional;
import com.baas.desafio.entity.Transacao;
import com.baas.desafio.entity.Conta;
import com.baas.desafio.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.baas.desafio.repository.ContaRepository;

public class TransacaoService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaService contaService;

    public List<Transacao> extratoTransacoes(Conta conta) {
        Optional<List<Transacao>> transacao = transacaoRepository.findByConta(conta);

        return transacao.get();
    }

    public Transacao transacao(Transacao transacao) {
        Optional<Conta> _conta = contaRepository.findById(transacao.getConta().getIdConta());

        contaService.verificaContaAtiva(_conta.get());

        Double vlrAtual = _conta.get().getSaldo();
        Double vlrTransacao = transacao.getValor();

        contaService.verificaContaTemSaldo(vlrAtual, vlrTransacao);

        _conta.get().setSaldo(vlrAtual+vlrTransacao);
        contaRepository.save(_conta.get());

        return transacaoRepository.save(transacao);

    }


}
