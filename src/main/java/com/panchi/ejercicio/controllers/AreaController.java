package com.panchi.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panchi.ejercicio.models.entities.Area;
import com.panchi.ejercicio.models.services.IAreaService;

@Controller
@RequestMapping(value="/area")
public class AreaController {
	@Autowired 
	private IAreaService srvArea;
	// https://localhost:808/area
	@GetMapping(value="/create")
	public String create(Model model) {
		Area area = new Area();
		model.addAttribute("title","Registre la nueva area");
		model.addAttribute("area",area); 
		
		return "area/form"; 
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id,Model model) {
		Area area =srvArea.findById(id);
		model.addAttribute("area",area);
		return "area/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id,Model model) {
		Area area =srvArea.findById(id);
		model.addAttribute("area",area);
		model.addAttribute("title","Actualizando el registro"+area);
		return "area/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id,Model model) {
		srvArea.delete(id);
		return "redirect:/area/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Area> areas = srvArea.findAll();
		model.addAttribute("areas",areas);
		model.addAttribute("title","Listado de areas");
		return "area/list";
		
	}
	
	@PostMapping(value="/save")
	public String save(Area area,Model model) {
		this.srvArea.save(area);
		return "redirect:/area/list";
	}
	
	
}
