package com.example.quintoElemento.services;

import com.example.quintoElemento.models.Alumno;
import com.example.quintoElemento.models.Profesor;

import java.util.List;

public interface ProfesorService {

    public List<Profesor> getAllProfesors();
    Profesor findProfesorByNombre(String nombre);

    Profesor findProfesorById(long id);

    void saveProfesor(Profesor profesor);

    void deleteProfesorById(long id);
}
