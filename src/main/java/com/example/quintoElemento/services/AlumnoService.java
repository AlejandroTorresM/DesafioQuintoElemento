package com.example.quintoElemento.services;

import com.example.quintoElemento.models.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> getAllAlumnos();

    Alumno findAlumnoByEmail(String email);

    Alumno findAlumnoById(long id);


    void saveAlumno(Alumno alumno);

    void deleteAlumnoById(long id);


}
