package com.proyecto.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personal_id;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	
	public int getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
