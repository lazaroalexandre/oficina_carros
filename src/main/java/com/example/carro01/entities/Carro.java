package com.example.carro01.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proprietario_id", referencedColumnName = "id")
    private Proprietario proprietario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carro")
    private List<Revisao> revisoes;
}
