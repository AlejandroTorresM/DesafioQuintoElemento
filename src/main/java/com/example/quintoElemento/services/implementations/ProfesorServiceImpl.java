package com.example.quintoElemento.services.implementations;

import com.example.quintoElemento.models.Profesor;
import com.example.quintoElemento.repositories.ProfesorRepositories;
import com.example.quintoElemento.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepositories profesorRepositories;

    @Override
    public List<Profesor> getAllProfesors(){
        return profesorRepositories.findAll();
    }
}
