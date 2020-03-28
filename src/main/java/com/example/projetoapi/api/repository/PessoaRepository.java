package com.example.projetoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoapi.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
