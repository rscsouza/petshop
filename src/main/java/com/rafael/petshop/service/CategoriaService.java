package com.rafael.petshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafael.petshop.domain.Categoria;
import com.rafael.petshop.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj= repo.findById(id);
		return obj.orElse(null);
	}

}
