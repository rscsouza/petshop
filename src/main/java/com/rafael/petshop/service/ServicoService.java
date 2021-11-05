package com.rafael.petshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafael.petshop.domain.Servico;
import com.rafael.petshop.repositories.ServicoRepository;
import com.rafael.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj= repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNaoEncontradoException("Objeto não encontrado ID "+id+", Tipo: "+Servico.class.getName()));
	}

}
