package com.example.carro01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carro01.entities.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
    
}
