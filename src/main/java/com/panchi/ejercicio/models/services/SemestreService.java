package com.panchi.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panchi.ejercicio.models.dao.ISemestre;
import com.panchi.ejercicio.models.entities.Semestre;

@Service
public class SemestreService  implements ISemestreService{
	
	@Autowired 
	private ISemestre dao;
	
	@Override
	@Transactional
	public void save(Semestre s) {
		dao.save(s);
		
	}

	@Override
	@Transactional
	public Semestre findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Semestre> findAll() {
		
		return (List<Semestre>) dao.findAll();
	}

}
