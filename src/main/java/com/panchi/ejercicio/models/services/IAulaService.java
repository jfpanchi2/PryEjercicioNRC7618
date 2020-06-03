package com.panchi.ejercicio.models.services;

import java.util.List;

import com.panchi.ejercicio.models.entities.Aula;

public interface IAulaService {
	public void save(Aula a);
	public Aula findById(Integer id);
	public void delete(Integer id);
	public List<Aula> findAll();

}
