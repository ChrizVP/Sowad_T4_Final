package com.proyecto.app.controllersRest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.app.models.Cliente;
import com.proyecto.app.models.Personal;
import com.proyecto.app.models.Servicio;
import com.proyecto.app.models.ServicioMecanicoCab;
import com.proyecto.app.models.ServicioMecanicoDet;
import com.proyecto.app.service.ClienteService;
import com.proyecto.app.service.PersonalService;
import com.proyecto.app.service.ServicioMecanicoCabService;
import com.proyecto.app.service.ServicioMecanicoDetService;
import com.proyecto.app.service.ServicioService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/cotizacion"})
public class CotizacionRestController {

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
	
	@GetMapping(path = {"/servicio/mecanico/getallcotizacion"})
	private List<ServicioMecanicoDet> getAllServicioMecanicoDet() {
		return ServicioMecanicoDetService.getAll();
	}
	
	@GetMapping(path = {"/servicio/cliente"})
	private List<Cliente> getAllCliente() {
		return ClienteService.getAll();
	}
	
	@GetMapping(path = {"/servicio/personal"})
	private List<Personal> getAllPersonal() {
		return PersonalService.getAll();
	}
	
	@GetMapping(path = {"/servicio/servicio"})
	private List<Servicio> getAllServicio() {
		return ServicioService.getAll();
	}
	
	@GetMapping(path = {"/servicio/getserviciodet"})
	private List<ServicioMecanicoDet> getListServicioMecanicoDet() {
		return this.servicioMecanicoCab.getServicioMecanicoDets();
	}
	
	@PostMapping(path = {"/servicio/new/servicio/mecanico/{cliente_id}/{personal_id}"},produces = "application/json")
	private List<ServicioMecanicoDet> newServicioMecanico(@PathVariable("cliente_id") int cliente_id, @PathVariable("personal_id") int personal_id, @RequestBody ServicioMecanicoCab servicioMecanicoCab){
		Personal personal = PersonalService.get(personal_id);
		Cliente cliente = ClienteService.get(cliente_id);
		this.servicioMecanicoCab = new ServicioMecanicoCab();
		this.servicioMecanicoCab.setPersonal(personal);
		this.servicioMecanicoCab.setCliente(cliente);
		this.servicioMecanicoCab.setFecha(servicioMecanicoCab.getFecha());
		return this.servicioMecanicoCab.getServicioMecanicoDets();
	}
	
	@PostMapping(path = {"/servicio/add/servicio/mecanico/{servicio_id}"},produces = "application/json")
	private List<ServicioMecanicoDet> addServicioMecanico(@RequestBody ServicioMecanicoDet servicioMecanicoDet, @PathVariable("servicio_id") int servicio_id){
		
		Servicio servicio = ServicioService.get(servicio_id);
		servicioMecanicoDet.setServicio(servicio);
		servicioMecanicoDet.setServicioMecanicoCab(this.servicioMecanicoCab);
		this.servicioMecanicoCab.addServicioDet(servicioMecanicoDet);
		return this.servicioMecanicoCab.getServicioMecanicoDets();
	}
	
	@GetMapping(path = {"/servicio/save/servicio/macanico"} )
	private boolean guardarServicioMecanico(RedirectAttributes f) {
		if(this.servicioMecanicoCab.getServicioMecanicoDets().isEmpty()) {
			f.addFlashAttribute("error","El detalle no puede estar Vacio!");
			return false;
		}else {
			ServicioMecanicoCabService.save(this.servicioMecanicoCab);
			for(ServicioMecanicoDet servicioMecanicoDet : this.servicioMecanicoCab.getServicioMecanicoDets()) {
				ServicioMecanicoDetService.save(servicioMecanicoDet);
			}
			f.addFlashAttribute("success","Grabado con exito");
			this.servicioMecanicoCab.clearServicioDet();
			this.servicioMecanicoCab =  new ServicioMecanicoCab();
			return true;
		}
		
	}
	
	@GetMapping(path = {"/servicio/remove/servicio/mecanico/{servicioDet_id}"})
	private List<ServicioMecanicoDet> removeServicioMecanico(@PathVariable("servicioDet_id") int servicioDet_id) {
		this.servicioMecanicoCab.removeServicioDet(servicioDet_id);
		return this.servicioMecanicoCab.getServicioMecanicoDets();
	}
	
	@GetMapping(path= {"/servicio/mecanico/cancelar"})
	private ServicioMecanicoCab cancelarServicioMecancico(){
		this.servicioMecanicoCab.clearServicioDet();
		this.servicioMecanicoCab = new ServicioMecanicoCab();
		return this.servicioMecanicoCab; 
	}
	
}
