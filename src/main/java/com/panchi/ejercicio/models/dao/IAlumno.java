package com.panchi.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.panchi.ejercicio.models.entities.Alumno;

public interface IAlumno extends CrudRepository<Alumno, Integer>{

}
