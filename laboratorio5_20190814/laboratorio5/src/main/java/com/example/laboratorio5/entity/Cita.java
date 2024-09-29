package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCitas")
    private Integer id;  // Cambia de int a Integer

    @Column(name = "motivoConsulta", nullable = false)
    private String motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idProfesional", nullable = false)
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idSede", nullable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "idFechaConsulta", nullable = false)
    private Fecha fechaConsulta;

    @ManyToOne
    @JoinColumn(name = "idRiesgo", nullable = false)
    private Riesgo riesgo;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "Citascol")
    private String citascol;
}
