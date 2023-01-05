package com.example.quintoElemento.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private Set<CursoProfesor> CursoProfesors = new HashSet<>();

    private String nombre;

    private String apellido;

    public Profesor(){}

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Profesor(String nombre, String apellido,Set<CursoProfesor> CursoProfesors) {
        this.CursoProfesors = CursoProfesors;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public Set<CursoProfesor> getCursoProfesors() {
        return CursoProfesors;
    }
    public void setCursoProfesors(Set<CursoProfesor> cursoProfesors) {
        CursoProfesors = cursoProfesors;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
