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

import com.proyecto.app.models.Personal;
import com.proyecto.app.service.PersonalService;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/personal"})
public class ProductoRestController {

	@Autowired
	private  PersonalService personalService;
	
	@GetMapping
	public List<Personal> listar() {
		System.out.println(personalService.getAll());
		return personalService.getAll();
	}
	
	@PostMapping
	public Personal agregar(@RequestBody Personal p) {
		return personalService.save(p);
		
	}
	
	@GetMapping(path = {"/{personal_id}"})
	public Personal listarId(@PathVariable("personal_id") int producto_id) {
			return personalService.get(producto_id);
	}
	
	@PutMapping(path = {"/{personal_id}"})
	public Personal editar(@RequestBody Personal producto, @PathVariable("personal_id") int personal_id) {
		producto.setPersonal_id(personal_id);
		return personalService.save(producto);
	}
	
	@DeleteMapping(path= {"/{personal_id}"})
	public void delete(@PathVariable("personal_id") int personal_id) {
		personalService.deleted(personal_id);
	}
	
	
}
