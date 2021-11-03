package com.rafael.petshop.utils;

import org.springframework.stereotype.Component;

import com.rafael.petshop.domain.Categoria;
import com.rafael.petshop.domain.Especie;
import com.rafael.petshop.domain.Pet;
import com.rafael.petshop.domain.Produto;
import com.rafael.petshop.domain.Raca;
import com.rafael.petshop.repositories.CategoriaRepository;
import com.rafael.petshop.repositories.EspecieRepository;
import com.rafael.petshop.repositories.PetRepository;
import com.rafael.petshop.repositories.ProdutoRepository;
import com.rafael.petshop.repositories.RacaRepository;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
@Component
public class PopulaDados {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@PostConstruct
	public void cadastrar() {
		Categoria cat1= new Categoria(null,"Alimento");
		Categoria cat2= new Categoria(null,"Remédio");
		Categoria cat3= new Categoria(null,"Cosmético");
						
		Produto p1= new Produto(null,"Ração",100.0);
		Produto p2= new Produto(null,"Sache",80.0);
		Produto p3= new Produto(null,"Vermifugo",20.0);
		Produto p4= new Produto(null,"Shampoo",50.0);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p3,p4));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2,cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		Especie esp1= new Especie(null,"Cachorro");
		Especie esp2= new Especie(null,"Gato");
		
		Raca rac1= new Raca(null,"Shitzu");
		Raca rac2= new Raca(null,"Akita");
		Raca rac3= new Raca(null,"Persa");
		
		Pet pet1 = new Pet(null,"Jonh",6,esp1,rac1);
		Pet pet2 = new Pet(null,"Hana",5,esp1,rac2);
		Pet pet3 = new Pet(null,"Mewth",8,esp2,rac3);
		
		especieRepository.saveAll(Arrays.asList(esp1,esp2));
		racaRepository.saveAll(Arrays.asList(rac1,rac2,rac3));
		petRepository.saveAll(Arrays.asList(pet1,pet2,pet3));
	}
	
	
}
