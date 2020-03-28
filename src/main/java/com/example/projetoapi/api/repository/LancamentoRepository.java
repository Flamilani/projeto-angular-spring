package com.example.projetoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoapi.api.model.Lancamento;
import com.example.projetoapi.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
