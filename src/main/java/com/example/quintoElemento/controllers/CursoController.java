package com.example.quintoElemento.controllers;

import com.example.quintoElemento.dtos.CursoDTO;
import com.example.quintoElemento.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/cursos")
    public List<CursoDTO> getCursos(){
        return cursoService.getAllCursos().stream().map(curso -> new CursoDTO(curso)).collect(Collectors.toList());
    }
}
