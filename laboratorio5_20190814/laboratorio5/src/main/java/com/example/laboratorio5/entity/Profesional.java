package com.example.laboratorio5.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profesionales")
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesionales")
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "imagen", nullable = false, length = 45)
    private String imagen;

    @Column(name = "descripcionProfesional", nullable = false, length = 90)
    private String descripcionProfesional;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idSede", nullable = false)
    private Sede sede;

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fecha> fechas; // Relación con fechas

}

