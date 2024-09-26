package com.example.laboratirio5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalesController {

    @GetMapping(value = {"", "/"})
    public String listaProfesionales() {
        return "profesionales";
    }

    @GetMapping("/registrar")
    public String registrarProfesionales() {
        return "formRegistrarCita";
    }


}
