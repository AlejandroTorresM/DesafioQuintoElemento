package com.example.quintoElemento.controllers;

import com.example.quintoElemento.dtos.CursoProfesorDTO;
import com.example.quintoElemento.services.CursoProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CursoProfesorController {

    @Autowired
    CursoProfesorService cursoProfesorService;

    @GetMapping("/cursoProfesor")
    public List<CursoProfesorDTO> getCursoProfesor(){
        return cursoProfesorService.getAllCursoProfesor().stream().map(cursoProfesor -> new CursoProfesorDTO(cursoProfesor)).collect(Collectors.toList());
    }
}
