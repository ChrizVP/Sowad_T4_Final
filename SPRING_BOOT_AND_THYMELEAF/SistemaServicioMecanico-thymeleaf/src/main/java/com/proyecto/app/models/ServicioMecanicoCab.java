package com.proyecto.app.models;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Component
public class ServicioMecanicoCab  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int servicioCab_id;
		
	@Column
	private Float total=0.0f;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Personal personal;
	
	@Column
	private Date fecha;
	
	
	@Transient
	int contador;
	
	public ServicioMecanicoCab() {
		
	}
	@JsonBackReference
	@OneToMany(mappedBy = "servicioMecanicoCab", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<ServicioMecanicoDet> servicioMecanicoDets = new ArrayList<>();

	public ServicioMecanicoCab(int servicioCab_id, Float total, Cliente cliente, Personal personal, Servicio servicio,
			Date fecha) {
		super();
		this.servicioCab_id = servicioCab_id;
		this.total = total;
		this.cliente = cliente;
		this.personal = personal;
		this.fecha = fecha;
	}

	public int getServicioCab_id() {
		return servicioCab_id;
	}

	public void setServicioCab_id(int servicioCab_id) {
		this.servicioCab_id = servicioCab_id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<ServicioMecanicoDet> getServicioMecanicoDets() {
		return servicioMecanicoDets;
	}

	public void setServicioMecanicoDets(List<ServicioMecanicoDet> servicioMecanicoDets) {
		this.servicioMecanicoDets = servicioMecanicoDets;
	}

	public void addServicioDet(ServicioMecanicoDet servicioMecanicoDet) {
		
		if(servicioMecanicoDets.isEmpty()) {
			contador = 0;
			servicioMecanicoDet.setServicioDet_id(contador);
			contador++;
		}else {
			servicioMecanicoDet.setServicioDet_id(contador);
			contador++;
		}
		
		servicioMecanicoDets.add(servicioMecanicoDet);
	}
	
	public void clearServicioDet() {
		servicioMecanicoDets.clear();
	}
	
	public void removeServicioDet(int servicioDet_id) {
		
		Iterator<ServicioMecanicoDet> it = servicioMecanicoDets.iterator();
		while (it.hasNext()) {
		    if (it.next().getServicioDet_id() == servicioDet_id) {
		        it.remove();
		    }
		}
	}
	
}
