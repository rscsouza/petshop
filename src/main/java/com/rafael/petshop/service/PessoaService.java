package com.rafael.petshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafael.petshop.domain.Pessoa;
import com.rafael.petshop.repositories.PessoaRepository;
import com.rafael.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj= repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNaoEncontradoException("Objeto não encontrado ID "+id+", Tipo: "+Pessoa.class.getName()));
	}

}
