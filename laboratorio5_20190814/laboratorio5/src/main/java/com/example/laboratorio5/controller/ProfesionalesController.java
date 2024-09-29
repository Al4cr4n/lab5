package com.example.laboratorio5.controller;

import com.example.laboratorio5.entity.Fecha;
import com.example.laboratorio5.entity.Profesional;
import com.example.laboratorio5.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;


import java.util.List;


@Controller
@RequestMapping("/profesionales")
public class ProfesionalesController {

    final ProfesionalRepository profesionalRepository;

    public ProfesionalesController(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaProfesionales(@RequestParam(required = false) String area,
                                     @RequestParam(required = false) String sede,
                                     Model model) {
        List<Profesional> profesionales;

        if (area != null && sede != null) {
            profesionales = profesionalRepository.findByAreaNombreAreaAndSedeNombreSede(area, sede);
        } else if (area != null) {
            profesionales = profesionalRepository.findByAreaNombreArea(area);
        } else if (sede != null) {
            profesionales = profesionalRepository.findBySedeNombreSede(sede);
        } else {
            // Aquí utilizas el método que trae los profesionales con las fechas
            profesionales = profesionalRepository.findAllWithFechas();
        }

        model.addAttribute("profesionales", profesionales);
        return "Profesionales/profesionales";
    }

    @GetMapping("/registrar")
    public String registrarProfesionales() {
        return "Profesionales/formRegistrarCita";
    }

    @GetMapping("/filtrar")
    public String filtrarProfesional(@RequestParam(value = "area", required = false) String area,
                                     @RequestParam(value = "sede", required = false) String sede,
                                     @RequestParam(value = "fecha", required = false) String fecha,
                                     Model model) {

        List<Profesional> listaProfesional;

        if (area != null && sede != null && fecha != null) {
            listaProfesional = profesionalRepository.findByAreaNombreAreaAndSedeNombreSede(area, sede);
            listaProfesional = listaProfesional.stream()
                    .filter(p -> p.getFechas().stream()
                            .anyMatch(f -> f.getFechaDisponibilidad().toString().equals(fecha)))
                    .collect(Collectors.toList());
        } else if (area != null) {
            listaProfesional = profesionalRepository.findByAreaNombreArea(area);
        } else if (sede != null) {
            listaProfesional = profesionalRepository.findBySedeNombreSede(sede);
        } else if (fecha != null) {
            listaProfesional = profesionalRepository.findByFechaDisponibilidad(fecha);
        } else {
            listaProfesional = profesionalRepository.findAllWithFechas();
        }

        model.addAttribute("profesionales", listaProfesional);

        return "Profesionales/profesionales";
    }


}






