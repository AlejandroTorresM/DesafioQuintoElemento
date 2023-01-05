package com.example.quintoElemento.services.implementations;


import com.example.quintoElemento.models.Curso;
import com.example.quintoElemento.repositories.CursoRepositories;
import com.example.quintoElemento.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepositories cursoRepositories;

    @Override
    public List<Curso> getAllCursos(){
        return cursoRepositories.findAll();
    }

    @Override
    public Curso findCursoByNombre(String nombre){return cursoRepositories.findByNombre(nombre);}

    @Override
    public Curso findCursoById(long id){return cursoRepositories.findById(id);}

    @Override
    public void saveCurso(Curso curso){cursoRepositories.save(curso);}

    @Override
    public void deleteCurso(long id){cursoRepositories.deleteById(id);}

}
