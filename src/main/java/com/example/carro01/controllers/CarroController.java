package com.example.carro01.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carro01.entities.Carro;
import com.example.carro01.repositories.CarroRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarroController {

    CarroRepository carroRepository;

    @GetMapping("carro/list")
    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    @GetMapping("carro/detail/{id}")
    public Carro getCarroId(@PathVariable Long id) {
        return carroRepository.findById(id).get();
    }

    @PostMapping("carro/create")
    public Carro saveCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @DeleteMapping("carro/delete/{id}")
    public void deleteCarro(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }
    // ...

    @PutMapping("carro/update/{id}")
    public Carro updateCarro(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
        Carro carroExistente = carroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carro não encontrado"));
        carroExistente.setMarca(carroAtualizado.getMarca());
        carroExistente.setModelo(carroAtualizado.getModelo());
        carroExistente.setAno(carroAtualizado.getAno());
        carroExistente.setProprietario(carroAtualizado.getProprietario());
        return carroRepository.save(carroExistente);
    }

}
