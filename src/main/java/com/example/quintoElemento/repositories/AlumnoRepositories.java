package com.example.quintoElemento.repositories;

import com.example.quintoElemento.models.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlumnoRepositories extends JpaRepository<Alumno,Long> {
    Alumno findByEmail(String email);
    Alumno findById(long id);
}
