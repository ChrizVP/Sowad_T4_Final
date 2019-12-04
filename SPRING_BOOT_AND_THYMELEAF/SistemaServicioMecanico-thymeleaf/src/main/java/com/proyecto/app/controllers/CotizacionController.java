package com.proyecto.app.controllers;



import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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
		
		float montoCotizacion=0.0f;
		List<ServicioMecanicoDet> serMecanicoDets = new ArrayList<ServicioMecanicoDet>();
		serMecanicoDets = ServicioMecanicoDetService.getAll();
		Iterator<ServicioMecanicoDet> it = serMecanicoDets.iterator();
		while (it.hasNext()) {
		    montoCotizacion += it.next().getServicio().getMonto(); 
		}
		model.addAttribute("clienteTotal", this.ClienteService.getAll().size());
		model.addAttribute("nroCotizaciones", this.ServicioMecanicoCabService.getAll().size());
		model.addAttribute("servicioTotal", this.ServicioService.getAll().size());
		model.addAttribute("montoCotizacion", montoCotizacion);
				
		return "Home";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/cotizacion/home", method = RequestMethod.GET)
	private String servicioHome(Model model) {
		model.addAttribute("servicioMecanicoDets", ServicioMecanicoDetService.getAll());
		return "cotizacionHome";
	}
	
	
	@RequestMapping(value = "/cotizacion", method = RequestMethod.GET)
	private String servicio(Model model) {
		if(this.servicioMecanicoCab == null) {
			this.servicioMecanicoCab = new ServicioMecanicoCab();
		}
		
		model.addAttribute("clientes", ClienteService.getAll());
		model.addAttribute("personals", PersonalService.getAll());
		return "cotizacionNew";
	}
	
	@RequestMapping(value = "/cotizacion/new/detalle", method = RequestMethod.POST)
	private String newServicioDet(Model model, SessionStatus status, RedirectAttributes f,@RequestParam("cliente_id") int cliente_id, @RequestParam("personal_id") int personal_id, 
									@RequestParam("fecha") Date fecha)  {
		
		
		Personal personal = PersonalService.get(personal_id);
		Cliente cliente = ClienteService.get(cliente_id);
		this.servicioMecanicoCab.setPersonal(personal);
		this.servicioMecanicoCab.setCliente(cliente);
		this.servicioMecanicoCab.setFecha(fecha);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "cotizacionDet";
	}
	
	@RequestMapping(value = "/cotizacion/add/detalle", method = RequestMethod.POST)
	private String addServicioDet(@Valid ServicioMecanicoDet servicioMecanicoDet ,Model model, SessionStatus status, RedirectAttributes f,@RequestParam("servicio_id") int servicio_id) {
		Servicio servicio = ServicioService.get(servicio_id);
		servicioMecanicoDet.setServicio(servicio);
		servicioMecanicoDet.setServicioMecanicoCab(this.servicioMecanicoCab);
		this.servicioMecanicoCab.addServicioDet(servicioMecanicoDet);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "cotizacionDet";
	}
	
	//ERROR AL GUARADAR xD

	@RequestMapping(value = "/fallo/cotizacion/save/detalle")
	private String errorGuadarServicioDet(Model model) {
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		model.addAttribute("lista", true);
		return "cotizacionDet";
	}
	
	
	@RequestMapping(value = "/cotizacion/save/detalle")
	private String guardarServicioDet(RedirectAttributes f){
		if(this.servicioMecanicoCab.getServicioMecanicoDets().isEmpty()) {
			return "redirect:/fallo/cotizacion/save/detalle";
		}
		ServicioMecanicoCabService.save(this.servicioMecanicoCab);
		for(ServicioMecanicoDet servicioMecanicoDet : this.servicioMecanicoCab.getServicioMecanicoDets()) {
			ServicioMecanicoDetService.save(servicioMecanicoDet);
		}
		f.addFlashAttribute("success","Grabado con exito");
		this.servicioMecanicoCab.clearServicioDet();
		this.servicioMecanicoCab =  new ServicioMecanicoCab();
		return "redirect:/cotizacion/home";
	}
	
	@RequestMapping(value="/cotizacion/remove/{id}", method = RequestMethod.GET)
	private String removeServicioDet(Model model, @PathVariable int id) {
		this.servicioMecanicoCab.removeServicioDet(id);
		model.addAttribute("servicios", ServicioService.getAll());
		model.addAttribute("servicioMecanicoDet", new ServicioMecanicoDet());
		model.addAttribute("servicioMecanicoDets", this.servicioMecanicoCab.getServicioMecanicoDets());
		return "cotizacionDet";
	}
	
	@RequestMapping(value = "/cotizacion/cancelar")
	private String cancelarServicioDet(){
		this.servicioMecanicoCab.clearServicioDet();
		this.servicioMecanicoCab = new ServicioMecanicoCab();
		return "redirect:/cotizacion"; 
	}
}