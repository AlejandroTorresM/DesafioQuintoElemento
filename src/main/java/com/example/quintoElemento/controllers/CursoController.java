package com.example.quintoElemento.controllers;

import com.example.quintoElemento.dtos.CursoDTO;
import com.example.quintoElemento.models.Curso;
import com.example.quintoElemento.models.Turno;
import com.example.quintoElemento.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/cursos")
    public ResponseEntity<Object> crearCurso(
            @RequestParam String nombreCurso, @RequestParam Turno turno){
        if (nombreCurso.isEmpty() || turno == null){
            return new ResponseEntity<>("Faltan datos", HttpStatus.FORBIDDEN);
        }
        Curso curso = new Curso(nombreCurso,turno);
        cursoService.saveCurso(curso);
        return new ResponseEntity<>("Curso Creado", HttpStatus.CREATED);
    }

    @DeleteMapping("/cursos/{id}/delete")
    public ResponseEntity<Object> eliminarCruso(
            @PathVariable long id){
        cursoService.deleteCurso(id);
        return new ResponseEntity<>("Curso eliminado con exito",HttpStatus.ACCEPTED);
    }

    @PatchMapping("/cursos/{id}/update")
    public ResponseEntity<Object> modificarCuros(
            @PathVariable long id,
            @RequestParam String nombreCurso){
        Curso curso = cursoService.findCursoById(id);
        if (curso == null || nombreCurso.isEmpty()){
            return new ResponseEntity<>("Faltan datos", HttpStatus.FORBIDDEN);
        }
        curso.setNombre(nombreCurso);
        cursoService.saveCurso(curso);
        return new ResponseEntity<>("Curso Actualizado", HttpStatus.ACCEPTED);
    }
}
