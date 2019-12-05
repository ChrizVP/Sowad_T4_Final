package com.proyecto.app.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class ServicioMecanicoDet  implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int servicioDet_id;
	
	@Column
	public String marca;
	
	@Column
	public String modelo;
	
	@Column
	public String placa;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Servicio servicio;
	
	@Column
	public String contenido;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	public ServicioMecanicoCab servicioMecanicoCab;
	
	
	public ServicioMecanicoDet() {
		
	}


	public ServicioMecanicoDet(int servicioDet_id, String marca, String modelo, String placa, Servicio servicio,
			String contenido, ServicioMecanicoCab servicioMecanicoCab) {
		super();
		this.servicioDet_id = servicioDet_id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.servicio = servicio;
		this.contenido = contenido;
		this.servicioMecanicoCab = servicioMecanicoCab;
	}


	public int getServicioDet_id() {
		return servicioDet_id;
	}


	public void setServicioDet_id(int servicioDet_id) {
		this.servicioDet_id = servicioDet_id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public ServicioMecanicoCab getServicioMecanicoCab() {
		return servicioMecanicoCab;
	}


	public void setServicioMecanicoCab(ServicioMecanicoCab servicioMecanicoCab) {
		this.servicioMecanicoCab = servicioMecanicoCab;
	}


}
