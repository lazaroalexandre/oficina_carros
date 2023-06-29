package com.example.carro01.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carro01.entities.Revisao;
import com.example.carro01.repositories.RevisaoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RevisaoController {
    
    RevisaoRepository revisaoRepository;

    @GetMapping("/revisao/list")
    public List<Revisao> getAllRevisao(){
        return revisaoRepository.findAll();
    }

    @GetMapping("/revisao/detail/{id}")
    public Revisao getOneRevisao(@PathVariable Long id){
        return revisaoRepository.findById(id).get();
    }

    @PostMapping("/revisao/create")
    public Revisao saveRevisao(@RequestBody Revisao revisao){
        return revisaoRepository.save(revisao);
    }

    @DeleteMapping("/revisao/delete/{id}")
    public void deleRevisao(@PathVariable Long id){
        revisaoRepository.deleteById(id);
    }

    @PutMapping("/revisao/update/{id}")
    public Revisao updateRevisao(@PathVariable Long id, @RequestBody Revisao revisaoAtualizada){
        Revisao revisaoExistente = revisaoRepository.findById(id).get();
        revisaoExistente.setDescricao(revisaoAtualizada.getDescricao());
        revisaoExistente.setData(revisaoAtualizada.getData());
        revisaoExistente.setCarro(revisaoAtualizada.getCarro());
        return revisaoRepository.save(revisaoExistente);
    }
}
