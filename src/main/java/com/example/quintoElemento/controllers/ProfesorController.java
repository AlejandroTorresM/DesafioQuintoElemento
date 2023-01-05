package com.example.quintoElemento.controllers;

import com.example.quintoElemento.dtos.ProfesorAppDTO;
import com.example.quintoElemento.dtos.ProfesorDTO;
import com.example.quintoElemento.models.Curso;
import com.example.quintoElemento.models.CursoProfesor;
import com.example.quintoElemento.models.Profesor;
import com.example.quintoElemento.services.CursoProfesorService;
import com.example.quintoElemento.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @Autowired
    CursoProfesorService cursoProfesorService;

    @GetMapping("/profesores")
    public List<ProfesorDTO> getProfesores(){
        return profesorService.getAllProfesors().stream().map(profesor -> new ProfesorDTO(profesor)).collect(Collectors.toList());
    }

    @PostMapping("/profesores")
    public ResponseEntity<Object> registroProfesor(
            @RequestParam String nombre, @RequestParam String apellido){
        if (nombre.isEmpty() || apellido.isEmpty()){
            return new ResponseEntity<>("Faltan Datos", HttpStatus.FORBIDDEN);
        }
        Profesor profesor = new Profesor(nombre,apellido);
        profesorService.saveProfesor(profesor);
        return new ResponseEntity<>("Profesor Creado", HttpStatus.CREATED);
    }

    @DeleteMapping("/profesores/{id}/delete")
    public ResponseEntity<Object> borrarProfesor(
            @PathVariable long id){
        profesorService.deleteProfesorById(id);
        return new ResponseEntity<>("Profesor Eliminado", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/profesores/{id}/update")
    public ResponseEntity<Object> updateProfesor(
            @PathVariable long id, @RequestParam String nombre, @RequestParam String apellido){
        Profesor profesor = profesorService.findProfesorById(id);
        if (nombre.isEmpty() || apellido.isEmpty()){
            return new ResponseEntity<>("Faltan datos",HttpStatus.FORBIDDEN);
        }
        if (profesor == null){
            return new ResponseEntity<>("El profesor no existe", HttpStatus.FORBIDDEN);
        }
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesorService.saveProfesor(profesor);
        return new ResponseEntity<>("Profesor Actualizado", HttpStatus.ACCEPTED);
    }

    @PostMapping("/profesores/cursos")
    public ResponseEntity<Object> asignarCursoProfesor(
                @RequestParam Curso curso, @RequestParam Profesor profesor){
        if (curso == null || profesor == null){
            return new ResponseEntity<>("Faltan datos", HttpStatus.FORBIDDEN);
        }
        CursoProfesor cursoProfesor = new CursoProfesor(profesor,curso);
        cursoProfesorService.saveCursoProfesor(cursoProfesor);
        return new ResponseEntity<>("Profesoy y curso asignados correctamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/profesores/cursos/{id}/delete")
    public ResponseEntity<Object> deleteCursoProfesor(
            @PathVariable long id){
        cursoProfesorService.deleteCursoProfesorById(id);
        return new ResponseEntity<>("Profesor removido del curso exitosamente",HttpStatus.ACCEPTED);
    }
}
