package com.panchi.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.panchi.ejercicio.models.entities.Profesor;

public interface IProfesor extends CrudRepository<Profesor, Integer> {

}
