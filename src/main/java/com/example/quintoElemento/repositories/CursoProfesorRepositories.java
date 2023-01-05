package com.example.quintoElemento.repositories;

import com.example.quintoElemento.models.Alumno;
import com.example.quintoElemento.models.CursoProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoProfesorRepositories extends JpaRepository<CursoProfesor, Long> {
    CursoProfesor findById(long id);
}
