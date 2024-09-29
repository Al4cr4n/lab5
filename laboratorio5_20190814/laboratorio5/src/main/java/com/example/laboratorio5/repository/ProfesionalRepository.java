package com.example.laboratorio5.repository;

import com.example.laboratorio5.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    List<Profesional> findByAreaNombreArea(String area);

    List<Profesional> findBySedeNombreSede(String sede);

    List<Profesional> findByAreaNombreAreaAndSedeNombreSede(String area, String sede);

    @Query("SELECT p FROM Profesional p LEFT JOIN FETCH p.fechas f")
    List<Profesional> findAllWithFechas();

    @Query("SELECT p FROM Profesional p LEFT JOIN p.fechas f WHERE f.fechaDisponibilidad = :fecha")
    List<Profesional> findByFechaDisponibilidad(String fecha);

}
