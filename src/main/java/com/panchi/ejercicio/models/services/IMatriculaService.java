package com.panchi.ejercicio.models.services;

import java.util.List;

import com.panchi.ejercicio.models.entities.Matricula;

public interface IMatriculaService {
	public void save(Matricula m);
	public Matricula findById(Integer id);
	public void delete(Integer id);
	public List<Matricula> findAll();
}
