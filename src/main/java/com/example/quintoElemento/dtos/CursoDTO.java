package com.example.quintoElemento.dtos;

import com.example.quintoElemento.models.Curso;
import com.example.quintoElemento.models.Turno;

import java.util.Set;
import java.util.stream.Collectors;

public class CursoDTO {
    private long id;

    private String nombre;

    private Turno turno;

    private Set<AlumnoDTO> alumnos;

    private Set<CursoProfesorDTO> cursoProfesors;

    public CursoDTO(){}

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nombre = curso.getNombre();
        this.turno = curso.getTurno();
        this.alumnos = curso.getAlumnos().stream().map(alumno -> new AlumnoDTO(alumno)).collect(Collectors.toSet());
        this.cursoProfesors = curso.getCursoProfesors().stream().map(cursoProfesor -> new CursoProfesorDTO(cursoProfesor)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }

    public Set<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public Set<CursoProfesorDTO> getCursoProfesors() {
        return cursoProfesors;
    }
}
