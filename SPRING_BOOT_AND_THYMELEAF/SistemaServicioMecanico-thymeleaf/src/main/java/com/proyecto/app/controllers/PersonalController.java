package com.proyecto.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.proyecto.app.models.Personal;
import com.proyecto.app.service.PersonalService;

@Controller
public class PersonalController {

	@Autowired
	private PersonalService personalService;
	

	
	@RequestMapping("/personal/home")
	public String home(Model model) {
		model.addAttribute("List", personalService.getAll());
		
		return"personalHome";
	}
	
	@GetMapping("/personal/edit/{id}")
	public String showEdit(@PathVariable("id")Integer id, Model model) {
		if(id !=null && personalService.get(id)!=null){
		model.addAttribute("personal", personalService.get(id));
		
		return "personalEdit";
		}else {	
			return "404";
		}
	}
	
	@PostMapping("/personal/edit/{id}")
	public String saveEdit(Personal personal, Model model) {
		personalService.save(personal);
		return "redirect:/personal/home";
	}
	
	
	@GetMapping("/personal/new")
	public String saveNew(Model model) {
		model.addAttribute("personal", new Personal());
		return "personalSave";
	}
	
	@PostMapping("/personal/save/new")
	public String save(Personal personal, Model model) {
		personalService.save(personal);
		return "redirect:/personal/home";
		
	}
	@GetMapping("/personal/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		
		personalService.deleted(id);
		return "redirect:/personal/home";
	}
	
	
}
