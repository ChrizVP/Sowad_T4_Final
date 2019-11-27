package com.proyecto.app.controllersRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.app.models.Servicio;
import com.proyecto.app.service.ServicioService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/servicio"})
public class ServicioRestController {

	@Autowired
	private ServicioService servicioService;
	
	@GetMapping
	public List<Servicio>listar() {
		return servicioService.getAll();
	}
	
	@PostMapping
	public Servicio agregar(@RequestBody Servicio s) {
		return servicioService.save(s);
		
	}
	
	@GetMapping(path = {"/{servicio_id}"})
	public Servicio listarId(@PathVariable("servicio_id") int servicio_id) {
			return servicioService.get(servicio_id);
	}
	
	@PutMapping(path = {"/{servicio_id}"})
	public Servicio editar(@RequestBody Servicio servicio, @PathVariable("servicio_id") int servicio_id) {
		servicio.setServicio_id(servicio_id);;
		return servicioService.save(servicio);
	}
	
	@DeleteMapping(path= {"/{servicio_id}"})
	public void delete(@PathVariable("servicio_id") int servicio_id) {
		servicioService.deleted(servicio_id);
	}
	
}
