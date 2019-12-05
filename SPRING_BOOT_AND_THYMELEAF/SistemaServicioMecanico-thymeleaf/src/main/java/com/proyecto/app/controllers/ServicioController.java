package com.proyecto.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.proyecto.app.models.Servicio;
import com.proyecto.app.service.ServicioService;

@Controller
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	

	
	@RequestMapping("/servicio/home")
	public String home(Model model) {
		model.addAttribute("List", servicioService.getAll());
		return"servicioHome";
	}
	
	
	@GetMapping("/servicio/edit/{id}")
	public String showEdit(@PathVariable("id")Integer id, Model model) {
		if(id !=null && servicioService.get(id)!=null){
		model.addAttribute("servicio", servicioService.get(id));
		return "servicioEdit";
		}else {	
			return "404";
		}
	}
	
	@PostMapping("/servicio/edit/{id}")
	public String saveEdit(Servicio servicio, Model model) {
		servicioService.save(servicio);
		return "redirect:/servicio/home";
	}
	
	
	@GetMapping("/servicio/new")
	public String saveNew(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "servicioSave";
	}
	
	@PostMapping("/servicio/save/new")
	public String save(Servicio servicio, Model model) {
		servicioService.save(servicio);
		return "redirect:/servicio/home";
		
	}
	@GetMapping("/servicio/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		
		servicioService.deleted(id);
		return "redirect:/servicio/home";
	}
	
	
}
