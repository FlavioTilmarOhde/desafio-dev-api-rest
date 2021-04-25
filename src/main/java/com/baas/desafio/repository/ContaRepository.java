package com.baas.desafio.repository;

import org.springframework.data.jpa.repository.*;

import com.baas.desafio.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

    }