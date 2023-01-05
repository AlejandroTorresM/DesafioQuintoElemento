package com.example.quintoElemento.repositories;

import com.example.quintoElemento.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesorRepositories extends JpaRepository<Profesor,Long> {
    Profesor findByNombre(String nombre);
    Profesor findById(long id);
}
