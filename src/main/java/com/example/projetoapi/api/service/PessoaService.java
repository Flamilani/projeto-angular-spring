package com.example.projetoapi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.projetoapi.api.model.Pessoa;
import com.example.projetoapi.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
	Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
	
	if (!pessoaSalva.isPresent()) {
	throw new EmptyResultDataAccessException(1);
	}
	return pessoaRepository.save(pessoa);
	 }
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(codigo);
		Pessoa pessoaSalva = pessoaOptional.get();
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

}
