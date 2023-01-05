package com.example.quintoElemento.dtos;

import com.example.quintoElemento.models.Alumno;
import com.example.quintoElemento.models.Curso;

import java.time.LocalDate;

public class AlumnoDTO {

    private long id;

    private String nombre, apellido, historia,email;

    private LocalDate fechaDeNacimiento;

    private String curso;

    public AlumnoDTO(){}

    public AlumnoDTO(Alumno alumno){
        this.id = alumno.getId();
        this.nombre = alumno.getNombre();
        this.apellido = alumno.getApellido();
        this.historia = alumno.getHistoria();
        this.fechaDeNacimiento = alumno.getFechaDeNacimiento();
        this.email = alumno.getEmail();
        this.curso = alumno.getCurso().getNombre();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getHistoria() {
        return historia;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }
}
