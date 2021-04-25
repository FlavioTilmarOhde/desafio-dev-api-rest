package com.baas.desafio.repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

import com.baas.desafio.entity.Conta;
import com.baas.desafio.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

    Optional<List<Transacao>> findByConta(Conta conta);

}