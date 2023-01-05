package com.example.quintoElemento.services;

import com.example.quintoElemento.models.Curso;

import java.util.List;

public interface CursoService {
    public List<Curso> getAllCursos();

    Curso findCursoByNombre(String nombre);
    Curso findCursoById(long id);

    void saveCurso(Curso curso);

    void deleteCurso(long id);
}
