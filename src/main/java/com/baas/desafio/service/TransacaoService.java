package com.baas.desafio.service;

import java.util.List;
import java.util.Optional;
import com.baas.desafio.entity.Transacao;
import com.baas.desafio.entity.Conta;
import com.baas.desafio.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.baas.desafio.repository.ContaRepository;
import com.baas.desafio.exception.TransacaoException;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaService contaService;

    public Transacao depostio(Transacao transacao) {

        // Recupera a conta - já inclui lançamento de erro conta não existe
        Conta _conta = contaService.getConta(transacao.getConta().getIdConta());

        // verifica conta ativa - já inclui lançameno de erro se conta bloqueada
        contaService.verificaContaAtiva(_conta);

        // seta novo saldo
        _conta.setSaldo(_conta.getSaldo() + transacao.getValor());

        try {
            // persiste a transação
            transacaoRepository.save(transacao);
            // só persiste novo saldo da conta se não der erro na persistencia da transação
            contaRepository.save(_conta);

        } catch (Exception e) {
            throw new TransacaoException();
        }

        return transacao;
    }

    public Transacao saque(Transacao transacao) {

        // Recupera a conta - já inclui lançamento de erro conta não existe
        Conta _conta = contaService.getConta(transacao.getConta().getIdConta());

        // verifica conta ativa - já inclui lançameno de erro se conta bloqueada
        contaService.verificaContaAtiva(_conta);

        Double vlrAtual = _conta.getSaldo();

        // no caso de saque o valor da transação já deve vir com sinal negativo
        Double vlrTransacao = transacao.getValor();
        contaService.verificaContaTemSaldo(vlrAtual, vlrTransacao);

        // seta novo saldo
        _conta.setSaldo(vlrAtual+vlrTransacao);

        try {
            // persiste a transação
            transacaoRepository.save(transacao);
            // só persiste novo saldo da conta se não der erro na persistencia da transação
            contaRepository.save(_conta);
        }
        catch (Exception e)
        {
            throw new TransacaoException();
        }

        return transacao;

    }

    public List<Transacao> extratotransacoes(Long idConta) {

        // Recupera a conta - já inclui lançamento de erro conta não existe
        Conta _conta = contaService.getConta(idConta);

        // Obtem lista de transações de forma opcional caso não exista transações
        Optional<List<Transacao>> transacao = transacaoRepository.findByConta(_conta);

        return transacao.get();
    }
}
