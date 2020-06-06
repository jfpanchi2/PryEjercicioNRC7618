package com.panchi.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panchi.ejercicio.models.entities.Alumno;
import com.panchi.ejercicio.models.services.IAlumnoService;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	
	//Todas las gestiones que realiza este controlador comienzan con / alumno
	// https://localhost:808/alumno/create
	@Autowired 
	private IAlumnoService srvAlumno;
	
	//Cada metodo en el controlador gestiona una peticion al backen a traves de una url
	//La url pude ser escrita en el navegador o puede ser un hyper link o puede ser un action de un form
	
	@GetMapping(value="/create")// https://localhost:808/alumno/create
	public String create(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("title","Registre de nuevo alumn@");
		model.addAttribute("alumno",alumno); //enviar desde el controlador al frontend
		
		return "alumno/form"; //Ubicacion de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id,Model model) {
		Alumno alumno =srvAlumno.findById(id);
		model.addAttribute("alumno",alumno);
		return "alumno/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id,Model model) {
		Alumno alumno =srvAlumno.findById(id);
		model.addAttribute("alumno",alumno);
		model.addAttribute("title","Actualizando el registro"+alumno);
		return "alumno/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id,Model model) {
		srvAlumno.delete(id);
		return "redirect:/alumno/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Alumno> alumnos = srvAlumno.findAll();
		model.addAttribute("alumnos",alumnos);
		model.addAttribute("title","Listado de alumnos");
		return "alumno/list";
		
	}
	
	
	@PostMapping(value="/save")// https://localhost:808/alumno/create
	public String save(Alumno alumno,Model model) {
		this.srvAlumno.save(alumno);
		return "redirect:/alumno/list";
	}
	
	
}
