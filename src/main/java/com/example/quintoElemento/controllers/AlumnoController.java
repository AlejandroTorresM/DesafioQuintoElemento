package com.example.quintoElemento.controllers;


import com.example.quintoElemento.dtos.AlumnoDTO;
import com.example.quintoElemento.models.Alumno;
import com.example.quintoElemento.models.Curso;
import com.example.quintoElemento.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public List<AlumnoDTO> getAlumnos(){
        return alumnoService.getAllAlumnos().stream().map(alumno -> new AlumnoDTO(alumno)).collect(Collectors.toList());
    }

    @PostMapping("/alumnos")
    public ResponseEntity<Object> registro(
            @RequestParam Curso curso,
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam LocalDate fechaDeNacimiento, @RequestParam String historia,
            @RequestParam String email){
        if(nombre.isEmpty() || apellido.isEmpty() || historia.isEmpty() || email.isEmpty() || fechaDeNacimiento.isAfter(LocalDate.now())){
            return new ResponseEntity<>("Faltan Datos", HttpStatus.FORBIDDEN);
        }
        if(alumnoService.findAlumnoByEmail(email) != null){
            return new ResponseEntity<>("Email ya en uso", HttpStatus.FORBIDDEN);
        }
        Alumno alumno = new Alumno(curso,nombre,apellido,fechaDeNacimiento,historia,email);
        alumnoService.saveAlumno(alumno);
        return new ResponseEntity<>("Alumno creado con exito",HttpStatus.CREATED);
    }


    @DeleteMapping("/alumnos/delete/{id}")
    public ResponseEntity<Object> borrarAlumno(
            @PathVariable long id){
        alumnoService.deleteAlumnoById(id);
        return new ResponseEntity<>("Alumno eliminado con exito", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/alumnos/update/{id}")
    public ResponseEntity<Object> modificarAlumno(
            @PathVariable long id,
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String email, @RequestParam String historia,
            @RequestParam LocalDate fechaDeNacimiento){
        Alumno alumno = alumnoService.findAlumnoById(id);
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || historia.isEmpty() || fechaDeNacimiento.isAfter(LocalDate.now())){
            return new ResponseEntity<>("Faltan Datos", HttpStatus.FORBIDDEN);
        }
        if (alumno == null){
            return new ResponseEntity<>("El alumno no existe",HttpStatus.FORBIDDEN);
        }
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setEmail(email);
        alumno.setHistoria(historia);
        alumno.setFechaDeNacimiento(fechaDeNacimiento);
        alumnoService.saveAlumno(alumno);
        return new ResponseEntity<>("Alumno actualizado", HttpStatus.ACCEPTED);
    }
}
