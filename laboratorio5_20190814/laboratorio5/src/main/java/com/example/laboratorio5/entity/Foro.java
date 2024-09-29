package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForo")
    private int id;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "nombrePersona", nullable = false)
    private String nombrePersona;
}
