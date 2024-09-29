package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "fechas")
public class Fecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFechas")
    private int id;

    @Column(name = "fechaDisponibilidad", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "idProfesional", nullable = false)
    private Profesional profesional;

}
