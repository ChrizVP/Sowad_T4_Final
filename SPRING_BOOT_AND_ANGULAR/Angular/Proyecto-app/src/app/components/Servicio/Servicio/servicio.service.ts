import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Servicio } from '../Modelo/Servicio';


@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8080/servicio';

  getServicio(){
    return this.http.get<Servicio[]>(this.Url);
  }
  createServicio(servicio:Servicio){
    return this.http.post<Servicio>(this.Url,servicio);
  }
  getServicioId(servicio_id:number){
    return this.http.get<Servicio>(this.Url+"/"+servicio_id);
  }
  updateServicio(servicio:Servicio){
    return this.http.put<Servicio>(this.Url+"/"+servicio.servicio_id,servicio)
  }
  deleteServicio(servicio:Servicio){
    return this.http.delete<Servicio>(this.Url+"/"+servicio.servicio_id)
  }


}
