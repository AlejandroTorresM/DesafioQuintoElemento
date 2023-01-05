package com.example.quintoElemento.dtos;

public class ProfesorAppDTO {

    private long id;

    private String nombreProfesor;

    private String nombreCurso;

    public ProfesorAppDTO(){}

    public ProfesorAppDTO(CursoProfesorDTO cursoProfesorDTO) {
        this.id = cursoProfesorDTO.getId();
        this.nombreProfesor = cursoProfesorDTO.getNombreProfesor();
        this.nombreCurso = cursoProfesorDTO.getCursoNombre();
    }

    public long getId() {
        return id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
}
