package com.rafael.petshop.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.petshop.domain.Servico;
import com.rafael.petshop.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {

	@Autowired
	ServicoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Servico obj=service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
