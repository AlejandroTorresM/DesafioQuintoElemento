package com.example.quintoElemento.dtos;

import com.example.quintoElemento.models.Profesor;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfesorDTO {
    private long id;

    private Set<CursoProfesorDTO> cursoProfesors;

    private String nombre, apellido;

    public ProfesorDTO(){};

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.cursoProfesors = profesor.getCursoProfesors().stream().map(cursoProfesor -> new CursoProfesorDTO(cursoProfesor)).collect(Collectors.toSet());
        this.nombre = profesor.getNombre();
        this.apellido = profesor.getApellido();
    }

    public long getId() {
        return id;
    }

    public Set<CursoProfesorDTO> getCursoProfesors() {
        return cursoProfesors;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
