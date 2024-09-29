package com.example.laboratorio5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPacientes")
    private int id;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Pacientescol")
    private String pacientescol;
}

