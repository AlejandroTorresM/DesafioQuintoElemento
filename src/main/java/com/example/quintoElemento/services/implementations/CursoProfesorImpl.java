package com.example.quintoElemento.services.implementations;

import com.example.quintoElemento.models.CursoProfesor;
import com.example.quintoElemento.repositories.CursoProfesorRepositories;
import com.example.quintoElemento.services.CursoProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoProfesorImpl implements CursoProfesorService {

    @Autowired
    CursoProfesorRepositories cursoProfesorRepositories;

    @Override
    public List<CursoProfesor> getAllCursoProfesor(){
        return cursoProfesorRepositories.findAll();
    }
}
