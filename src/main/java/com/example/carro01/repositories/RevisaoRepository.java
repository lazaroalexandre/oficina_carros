package com.example.carro01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carro01.entities.Revisao;

public interface RevisaoRepository extends JpaRepository<Revisao, Long>{
    
}
