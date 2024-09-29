package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "riesgos")
public class Riesgo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRiesgos")
    private int id;

    @Column(name = "Bajo", nullable = false)
    private int bajo;

    @Column(name = "Moderado", nullable = false)
    private int moderado;

    @Column(name = "Alto", nullable = false)
    private int alto;

    @Column(name = "Muy Alto", nullable = false)
    private int muyAlto;
}

