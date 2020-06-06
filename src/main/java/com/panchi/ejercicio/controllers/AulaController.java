package com.panchi.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panchi.ejercicio.models.entities.Aula;
import com.panchi.ejercicio.models.services.IAulaService;

@Controller
@RequestMapping(value="/aula")
public class AulaController {
	
	@Autowired 
	private IAulaService srvAula;
	// https://localhost:808/aula
	@GetMapping(value="/create")
	public String create(Model model) {
		Aula aula = new Aula();
		model.addAttribute("title","Registre una nueva aula");
		model.addAttribute("aula",aula); 
		
		return "aula/form"; 
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id,Model model) {
		Aula aula =srvAula.findById(id);
		model.addAttribute("aula",aula);
		return "aula/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id,Model model) {
		Aula aula =srvAula.findById(id);
		model.addAttribute("aula",aula);
		model.addAttribute("title","Actualizando el registro"+aula);
		return "aula/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id,Model model) {
		srvAula.delete(id);
		return "redirect:/aula/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Aula> aulas = srvAula.findAll();
		model.addAttribute("aulas",aulas);
		model.addAttribute("title","Listado de aulas");
		return "aula/list";
		
	}
	
	@PostMapping(value="/save")
	public String save(Aula aula,Model model) {
		this.srvAula.save(aula);
		return "redirect:/aula/list";
	}
	
}
