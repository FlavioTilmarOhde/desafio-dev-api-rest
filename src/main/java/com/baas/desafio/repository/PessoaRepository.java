package com.baas.desafio.repository;

import org.springframework.data.jpa.repository.*;

import com.baas.desafio.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}