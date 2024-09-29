package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCanciones")
    private int id;

    @Column(name = "nombreCancion", nullable = false)
    private String nombreCancion;

    @Column(name = "tipoCancion", nullable = false)
    private int tipoCancion;

    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private Recurso recurso;
}

