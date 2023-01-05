package com.example.quintoElemento.dtos;

import com.example.quintoElemento.models.CursoProfesor;

public class CursoProfesorDTO {
    private long id;

    private String nombreProfesor, cursoNombre;

    public CursoProfesorDTO(){}

    public CursoProfesorDTO(CursoProfesor cursoProfesor) {
        this.id = cursoProfesor.getId();
        this.nombreProfesor = cursoProfesor.getProfesor().getNombre() + " " + cursoProfesor.getProfesor().getApellido();
        this.cursoNombre = cursoProfesor.getCurso().getNombre();
    }

    public long getId() {
        return id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }
}
