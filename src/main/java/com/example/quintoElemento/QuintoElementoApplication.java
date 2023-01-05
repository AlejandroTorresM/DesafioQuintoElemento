package com.example.quintoElemento;

import com.example.quintoElemento.models.*;
import com.example.quintoElemento.repositories.AlumnoRepositories;
import com.example.quintoElemento.repositories.CursoProfesorRepositories;
import com.example.quintoElemento.repositories.CursoRepositories;
import com.example.quintoElemento.repositories.ProfesorRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class QuintoElementoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuintoElementoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(AlumnoRepositories alumnoRepositories, CursoRepositories cursoRepositories, ProfesorRepositories profesorRepositories,
									  CursoProfesorRepositories cursoProfesorRepositories){
		return (args) ->{

			//CURSOS//
			Curso cursoA = new Curso("Curso A", Turno.MAÑANA);
			Curso cursoB = new Curso("Curso B",Turno.TARDE);

			//ALUMNOS//
			Alumno jorgeNuñez = new Alumno(cursoA,"Jorge","Nuñez", LocalDate.of(2000,9,15),"Jorge es un ñiño con capacidad de audio reducida","jorgenuñez@gmail.com");
			Alumno manuelPerez = new Alumno(cursoB,"Manuel", "Perez", LocalDate.of(2000,7,12),"Manuel le dan miendos los sacapuntas","manuelperez18@gmail.com");
			Alumno albertoGomez = new Alumno(cursoB,"Alberto", "Gomez", LocalDate.of(2000,2,2),"Alberto es un bueno en matematicas","alberto.gomez@hotmail.com");
			Alumno alexDelgado = new Alumno(cursoA,"Alexis", "Delgado", LocalDate.of(2001,10,20),"Es fan de Harry Styles","alexisdelgado_harry@yahoo.com");

			//PROFESORES//
			Profesor ramiroVelez = new Profesor("Ramiro","Velez");
			Profesor benitoLopez = new Profesor("Benito","Lopez");
			Profesor valeriaFlores = new Profesor("Valeria","Florez");




			CursoProfesor cursoProfesor1 = new CursoProfesor(ramiroVelez,cursoA);
			CursoProfesor cursoProfesor2 = new CursoProfesor(benitoLopez,cursoA);
			CursoProfesor cursoProfesor3 = new CursoProfesor(benitoLopez,cursoB);
			CursoProfesor cursoProfesor4 = new CursoProfesor(valeriaFlores,cursoB);

			cursoRepositories.save(cursoA);
			cursoRepositories.save(cursoB);

			alumnoRepositories.save(jorgeNuñez);
			alumnoRepositories.save(manuelPerez);
			alumnoRepositories.save(albertoGomez);
			alumnoRepositories.save(alexDelgado);

			profesorRepositories.save(ramiroVelez);
			profesorRepositories.save(benitoLopez);
			profesorRepositories.save(valeriaFlores);

			cursoProfesorRepositories.save(cursoProfesor1);
			cursoProfesorRepositories.save(cursoProfesor2);
			cursoProfesorRepositories.save(cursoProfesor3);
			cursoProfesorRepositories.save(cursoProfesor4);

		};
	}
}
