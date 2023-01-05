package com.example.quintoElemento.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private Set<Alumno> alumnos = new HashSet<>();

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private Set<CursoProfesor> cursoProfesors = new HashSet<>();

    private String nombre;

    private Turno turno;

    public Curso() {
    }

    public Curso(String nombre, Turno turno) {
        this.nombre = nombre;
        this.turno = turno;
    }

    public Curso(Set<Alumno> alumnos, Set<CursoProfesor> cursoProfesors, String nombre, Turno turno) {
        this.alumnos = alumnos;
        this.cursoProfesors = cursoProfesors;
        this.nombre = nombre;
        this.turno = turno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }


    public Set<CursoProfesor> getCursoProfesors() {
        return cursoProfesors;
    }

    public void setCursoProfesors(Set<CursoProfesor> cursoProfesors) {
        this.cursoProfesors = cursoProfesors;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}