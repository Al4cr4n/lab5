package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "frases")
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFrases")
    private int id;

    @Column(name = "frase")
    private String frase;

    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private Recurso recurso;
}

