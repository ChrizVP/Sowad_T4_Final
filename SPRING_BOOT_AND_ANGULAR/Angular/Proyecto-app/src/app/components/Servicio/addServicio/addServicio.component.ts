import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../Servicio/Modelo/Servicio';
import { ServicioService } from '../../Servicio/Servicio/servicio.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addServicio',
  templateUrl: './addServicio.component.html',
  styleUrls: ['./addServicio.component.css']
})
export class AddServicioComponent implements OnInit {

  constructor(private router:Router, private service:ServicioService) { }
  servicio:Servicio = new Servicio();
  ngOnInit() {
  }

  GuardarServicio(){
    if(this.servicio.nombre != null && this.servicio.monto != null){
      this.service.createServicio(this.servicio)
      .subscribe(data=>{
        this.showModal();
        this.router.navigate(["listarServicio"]);
      })
    }else{
      this.shoModalFallo();
    }
  }

  CancelarNew(){
    this.router.navigate(["listarServicio"]);
  }

  shoModalFallo(){
    Swal.fire({
    position: 'center',
    type: 'error',
    title: 'Faltan Datos!',
    showConfirmButton: false,
    timer: 1300
    });
  }

  showModal(){
    Swal.fire({
      position: 'center',
      type: 'success',
      title: 'Guardado con exito!',
      showConfirmButton: false,
      timer: 1500
    });
  }

}
