import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from 'src/app/components/Cliente/Modelo/Cliente';
import { Personal } from 'src/app/components/Producto/Modelo/Personal';
import { ServicioMecanicoCab }from 'src/app/components/cotizacion/Modelo/ServicioMecanicoCab';
import { Servicio } from '../Modelo/Servicio';
import { ServicioMecanicoDet } from '../Modelo/ServicioMecanicoDet';

@Injectable({
  providedIn: 'root'
})
export class CotizacionnewService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8080/cotizacion';

  listadoCliente(){
    return this.http.get<Cliente[]>(this.Url+"/servicio/cliente");
  }

  listadoPersonal(){
    return this.http.get<Personal[]>(this.Url+"/servicio/personal");
  }

  nuevoServicio(cliente_id:number,personal_id:number, servicioMecanicoCab:ServicioMecanicoCab){
    return this.http.post<ServicioMecanicoDet[]>(this.Url+"/servicio/new/servicio/mecanico/"+cliente_id+"/"+personal_id,servicioMecanicoCab);
  }

  listadoServicio(){
    return this.http.get<Servicio[]>(this.Url+"/servicio/servicio");
  }

  addServicioMecanicoDet(servicio_id:number, servicioMecanicoDet:ServicioMecanicoDet){
    return this.http.post<ServicioMecanicoDet[]>(this.Url+"/servicio/add/servicio/mecanico/"+servicio_id,servicioMecanicoDet);
  }

  listadoServicioMecanicoDet(){
    return this.http.get<ServicioMecanicoDet[]>(this.Url+"/servicio/getserviciodet");
  }

  removeServicioMecanicoDet(servicioDet_id:number){
    return this.http.get<ServicioMecanicoDet[]>(this.Url+"/servicio/remove/servicio/mecanico/"+servicioDet_id)
  }

  saveServicioMecanicoDet(){
    return this.http.get<Boolean>(this.Url+"/servicio/save/servicio/macanico");
  }

  cancelServicioMecanicoDet(){
    return this.http.get<ServicioMecanicoCab>(this.Url+"/servicio/mecanico/cancelar");
  }

  reportCotizacion(){
    return this.http.get<ServicioMecanicoDet[]>(this.Url+"/servicio/mecanico/getallcotizacion");
  }

}
