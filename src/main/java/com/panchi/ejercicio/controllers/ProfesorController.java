package com.panchi.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panchi.ejercicio.models.entities.Profesor;
import com.panchi.ejercicio.models.services.IProfesorService;

@Controller
@RequestMapping(value="/profesor")
public class ProfesorController {
	@Autowired 
	private IProfesorService srvProfesor;
	// https://localhost:808/profesor
	@GetMapping(value="/create")
	public String create(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("title","Registre el nuevo profesor");
		model.addAttribute("profesor",profesor); 
		return "profesor/form"; 
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id,Model model) {
		Profesor profesor =srvProfesor.findById(id);
		model.addAttribute("profesor",profesor);
		return "profesor/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id,Model model) {
		Profesor profesor =srvProfesor.findById(id);
		model.addAttribute("profesor",profesor);
		model.addAttribute("title","Actualizando el registro"+profesor);
		return "profesor/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id,Model model) {
		srvProfesor.delete(id);
		return "redirect:/profesor/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Profesor> profesores = srvProfesor.findAll();
		model.addAttribute("profesores",profesores);
		model.addAttribute("title","Listado de profesores");
		return "profesor/list";
		
	}
	
	@PostMapping(value="/save")
	public String save(Profesor profesor,Model model) {
		this.srvProfesor.save(profesor);
		return "redirect:/profesor/list";
	}
	
	
}
