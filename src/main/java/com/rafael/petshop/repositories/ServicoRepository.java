package com.rafael.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.petshop.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer> {

}
