import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../Servicio/Modelo/Servicio';
import { ServicioService } from '../../Servicio/Servicio/servicio.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editServicio',
  templateUrl: './editServicio.component.html',
  styleUrls: ['./editServicio.component.css']
})
export class EditServicioComponent implements OnInit {

  servicio:Servicio = new Servicio();
  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit() {
    this.EditarServicio();
  }

  EditarServicio(){
    let servicio_id=localStorage.getItem("servicio_id");
    this.service.getServicioId(+servicio_id)
    .subscribe(data=>{
      this.servicio=data;
    })
  }
  CancelarEdition(){
    this.router.navigate(["listarServicio"]);
  }

  ActualizarServicio(servicio:Servicio){
    
    this.service.updateServicio(servicio)
    .subscribe(data=>{
      this.servicio=data;
      this.showModal();
      this.router.navigate(["listarServicio"]);
    })
  }

  showModal(){
    Swal.fire({
      position: 'center',
      type: 'success',
      title: 'Actualizado con Exito!',
      showConfirmButton: false,
      timer: 1500
    });
  }
  

}
