package com.example.projetoapi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoapi.api.model.Lancamento;
import com.example.projetoapi.api.model.Pessoa;
import com.example.projetoapi.api.repository.LancamentoRepository;
import com.example.projetoapi.api.repository.PessoaRepository;
import com.example.projetoapi.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(Optional.ofNullable(lancamento.getPessoa().getCodigo()).orElse(0L));
		if(pessoaSalva.isPresent() || !pessoaSalva.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		};
		return lancamentoRepository.save(lancamento);
	}
}
