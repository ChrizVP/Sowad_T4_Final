package com.proyecto.app.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.app.models.Cliente;
import com.proyecto.app.models.Personal;
import com.proyecto.app.models.Servicio;
import com.proyecto.app.models.ServicioMecanicoCab;
import com.proyecto.app.models.ServicioMecanicoDet;
import com.proyecto.app.service.ServicioMecanicoCabService;
import com.proyecto.app.service.ServicioMecanicoDetService;
import com.proyecto.app.service.ServicioService;
import com.proyecto.app.service.ClienteService;
import com.proyecto.app.service.PersonalService;

@Controller
public class CotizacionController {

	@Autowired
	private ServicioMecanicoCabService ServicioMecanicoCabService;
	
	@Autowired
	private ServicioMecanicoDetService ServicioMecanicoDetService;
	
	@Autowired
	private  ClienteService ClienteService;
	
	@Autowired
	private PersonalService PersonalService;
	
	@Autowired
	private ServicioService ServicioService;
	
	private ServicioMecanicoCab servicioMecanicoCab;
	
	@RequestMapping("/")
	public String returnHome(Model model) {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String inicio(Model model) {
		return "Home";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/servicio/home", method = RequestMethod.GET)
	private String servicioHome(Model model) {
		model.addAttribute("servicioMecanicoDets", ServicioMecanicoDetService.getAll());
		return "ServicioHome";
	}
	
	
	@RequestMapping(value = "/servicio", method = RequestMethod.GET)
	private String servicio(Model model) {
		if(this.servicioMecanicoCab == null) {
			this.servicioMecanicoCab = new ServicioMecanicoCab();
		}
		
		model.addAttribute("clientes", ClienteService.getAll());
		model.addAttribute("personals", PersonalService.getAll());
		return "ServicioNew";
	}
	
	@RequestMapping(value = "/servicio/new/detalle", method = RequestMethod.POST)
	private String newServicioDet(Model model, SessionStatus status, RedirectAttributes f,@RequestParam("cliente_id") int cliente_id, @RequestParam("personal_id") int personal_id) {
		Personal personal = PersonalService.get(personal_id);
		Cliente cliente = ClienteService.get(cliente_id);
		this.servicioMecanicoCab.setPersonal(personal);
		this.servicioMecanicoCab.setCliente(cliente);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "ServicioDet";
	}
	
	@RequestMapping(value = "/servicio/add/detalle", method = RequestMethod.POST)
	private String addServicioDet(@Valid ServicioMecanicoDet servicioMecanicoDet ,Model model, SessionStatus status, RedirectAttributes f,@RequestParam("servicio_id") int servicio_id) {
		Servicio servicio = ServicioService.get(servicio_id);
		servicioMecanicoDet.setServicio(servicio);
		servicioMecanicoDet.setServicioMecanicoCab(this.servicioMecanicoCab);
		this.servicioMecanicoCab.addServicioDet(servicioMecanicoDet);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "ServicioDet";
	}
	
	@RequestMapping(value = "/servicio/save/detalle")
	private String guardarServicioDet(RedirectAttributes f){
		if(this.servicioMecanicoCab.getServicioMecanicoDets().isEmpty()) {
			f.addFlashAttribute("error","El detalle no puede estar Vacio!");
			return "redict:/service/add/detalle";
		}
		ServicioMecanicoCabService.save(this.servicioMecanicoCab);
		for(ServicioMecanicoDet servicioMecanicoDet : this.servicioMecanicoCab.getServicioMecanicoDets()) {
			ServicioMecanicoDetService.save(servicioMecanicoDet);
		}
		f.addFlashAttribute("success","Grabado con exito");
		this.servicioMecanicoCab.clearServicioDet();
		this.servicioMecanicoCab =  new ServicioMecanicoCab();
		return "redirect:/servicio";
	}
	
	@RequestMapping(value="/servicio/remove/{id}", method = RequestMethod.GET)
	private String removeServicioDet(Model model, @PathVariable int id) {
		this.servicioMecanicoCab.removeServicioDet(id);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "ServicioDet";
	}
	
	@RequestMapping(value = "/servicio/cancelar")
	private String cancelarServicioDet(){
		this.servicioMecanicoCab.clearServicioDet();
		this.servicioMecanicoCab = new ServicioMecanicoCab();
		return "redirect:/servicio"; 
	}
}