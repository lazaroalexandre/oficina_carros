package com.example.carro01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carro01.entities.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

}
