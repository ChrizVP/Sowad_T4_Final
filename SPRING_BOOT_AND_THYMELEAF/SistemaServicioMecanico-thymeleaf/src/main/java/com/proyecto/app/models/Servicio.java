package com.proyecto.app.models;

import java.io.Serializable;

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
public class Servicio implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int servicio_id;
	@Column
	private String nombre;
	@Column
	private float monto;
	 
	
	public Servicio() {
	}


	public Servicio(int servicio_id, String nombre, float monto) {
		super();
		this.servicio_id = servicio_id;
		this.nombre = nombre;
		this.monto = monto;
	}


	public int getServicio_id() {
		return servicio_id;
	}


	public void setServicio_id(int servicio_id) {
		this.servicio_id = servicio_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getMonto() {
		return monto;
	}


	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
