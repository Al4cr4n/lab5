package com.example.laboratorio5.controller;

import com.example.laboratorio5.entity.Area;
import com.example.laboratorio5.entity.Sede;
import com.example.laboratorio5.entity.Cita;
import com.example.laboratorio5.entity.Profesional;
import com.example.laboratorio5.repository.AreaRepository;
import com.example.laboratorio5.repository.CitaRepository;
import com.example.laboratorio5.repository.ProfesionalRepository;
import com.example.laboratorio5.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitasController {

    final ProfesionalRepository profesionalRepository;
    final AreaRepository areaRepository;
    final SedeRepository sedeRepository;
    final CitaRepository citaRepository;

    public CitasController(ProfesionalRepository profesionalRepository, AreaRepository areaRepository, SedeRepository sedeRepository, CitaRepository citaRepository) {
        this.profesionalRepository = profesionalRepository;
        this.areaRepository = areaRepository;
        this.sedeRepository = sedeRepository;
        this.citaRepository = citaRepository;

    }

    @GetMapping("")
    public String listarCitas(Model model) {
        List<Cita> citas = citaRepository.findAll();
        model.addAttribute("citas", citas);
        return "Citas/listaCitas";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistroCita(Model model) {
        List<Area> listaAreas = areaRepository.findAll();
        List<Profesional> listaProfesionales = profesionalRepository.findAll();
        List<Sede> listaSedes = sedeRepository.findAll();

        System.out.println("Áreas: " + listaAreas.size()); // Verifica si tiene datos
        System.out.println("Profesionales: " + listaProfesionales.size()); // Verifica si tiene datos
        System.out.println("Sedes: " + listaSedes.size()); // Verifica si tiene datos

        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaProfesionales", listaProfesionales);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("cita", new Cita());

        return "Profesionales/formRegistrarCita";
    }






    @PostMapping("/reservar")
    public String registrarCita(Cita cita, RedirectAttributes redirectAttributes) {
        try {
            // Lógica para validar y registrar la cita
            citaRepository.save(cita);
            redirectAttributes.addFlashAttribute("successMessage", "Cita registrada exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Hubo un error al registrar la cita.");
        }
        return "redirect:/citas/registrar";
    }

}
