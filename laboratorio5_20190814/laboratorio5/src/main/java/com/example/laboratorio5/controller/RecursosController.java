package com.example.laboratorio5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recursos")
public class RecursosController {
    @GetMapping("")
    public String listarCitas(Model model) {


        return "Recursos/listaRecursos";
    }
}
