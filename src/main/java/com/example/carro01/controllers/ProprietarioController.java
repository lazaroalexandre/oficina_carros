package com.example.carro01.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carro01.entities.Proprietario;
import com.example.carro01.repositories.ProprietarioRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProprietarioController {

    ProprietarioRepository proprietarioRepository;

    @GetMapping("/proprietario/list")
    public List<Proprietario> getAllProprietarios(){
        return proprietarioRepository.findAll();
    }

    @GetMapping("/proprietario/detail/{id}")
    public Proprietario getOneProprietario(@PathVariable Long id){
        return proprietarioRepository.findById(id).get();
    }

    @PostMapping("/proprietario/create")
    public Proprietario saveProprietario(@RequestBody Proprietario proprietario){
        return proprietarioRepository.save(proprietario);
    }

    @DeleteMapping("/proprietario/delete/{id}")
    public void deleteProprietario(@PathVariable Long id){
        proprietarioRepository.deleteById(id);
    }

    @PutMapping("/proprietario/update/{id}")
    public Proprietario updateProprietario(@PathVariable Long id, @RequestBody Proprietario proprietarioAtualizado){
        Proprietario proprietarioExistente = proprietarioRepository.findById(id).get();
        proprietarioExistente.setNome(proprietarioAtualizado.getNome());
        proprietarioExistente.setEndereco(proprietarioAtualizado.getEndereco());
        return proprietarioRepository.save(proprietarioExistente);
    }
}
