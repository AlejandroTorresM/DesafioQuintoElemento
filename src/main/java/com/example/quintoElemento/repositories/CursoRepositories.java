package com.example.quintoElemento.repositories;

import com.example.quintoElemento.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoRepositories extends JpaRepository<Curso,Long> {
}
