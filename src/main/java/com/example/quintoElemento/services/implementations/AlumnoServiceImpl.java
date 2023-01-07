package com.example.quintoElemento.services.implementations;

import com.example.quintoElemento.models.Alumno;
import com.example.quintoElemento.repositories.AlumnoRepositories;
import com.example.quintoElemento.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepositories alumnoRepositories;

    @Override
    public List<Alumno> getAllAlumnos(){
        return alumnoRepositories.findAll();
    }



    @Override
    public Alumno findAlumnoByEmail(String email){return alumnoRepositories.findByEmail(email);}

    @Override
    public Alumno findAlumnoById(long id){return alumnoRepositories.findById(id);}

    @Override
    public void saveAlumno (Alumno alumno){
        alumnoRepositories.save(alumno);
    }

    @Override
    public void deleteAlumnoById(long id){alumnoRepositories.deleteById(id);}


}
