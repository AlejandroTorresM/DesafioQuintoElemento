package com.example.quintoElemento.services;

import com.example.quintoElemento.models.CursoProfesor;

import java.util.List;

public interface CursoProfesorService {

    public List<CursoProfesor> getAllCursoProfesor();

    CursoProfesor findCursoProfesorById(long id);

    void saveCursoProfesor(CursoProfesor cursoProfesor);

    void deleteCursoProfesorById(long id);
}
