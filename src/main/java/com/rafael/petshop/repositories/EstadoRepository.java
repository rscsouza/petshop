package com.rafael.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.petshop.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}