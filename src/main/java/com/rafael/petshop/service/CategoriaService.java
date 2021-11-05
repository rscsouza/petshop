package com.rafael.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafael.petshop.domain.Categoria;
import com.rafael.petshop.repositories.CategoriaRepository;
import com.rafael.petshop.service.exceptions.DataIntegrityException;
import com.rafael.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj= repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNaoEncontradoException("Objeto não encontrado ID "+id+", Tipo: "+Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produtos. Não é possível deletar.");
		}
	}

	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
