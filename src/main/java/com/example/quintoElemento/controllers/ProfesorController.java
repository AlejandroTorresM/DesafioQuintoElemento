package com.example.quintoElemento.controllers;

import com.example.quintoElemento.dtos.ProfesorDTO;
import com.example.quintoElemento.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesores")
    public List<ProfesorDTO> getProfesores(){
        return profesorService.getAllProfesors().stream().map(profesor -> new ProfesorDTO(profesor)).collect(Collectors.toList());
    }
}
