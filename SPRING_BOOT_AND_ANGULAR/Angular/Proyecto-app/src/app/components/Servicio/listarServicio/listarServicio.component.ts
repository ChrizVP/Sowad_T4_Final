import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../Servicio/Modelo/Servicio';
import { ServicioService } from '../../Servicio/Servicio/servicio.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listarServicio',
  templateUrl: './listarServicio.component.html',
  styleUrls: ['./listarServicio.component.css']
})
export class ListarServicioComponent implements OnInit {

  servicios:Servicio[];
  constructor(private service:ServicioService, private router:Router) { }

  ngOnInit() {
    this.service.getServicio()
    .subscribe(data=>{
      this.servicios=data;
    })
  }

  EditarServicio(servicio:Servicio):void{
    localStorage.setItem("servicio_id",servicio.servicio_id.toString());
    this.router.navigate(["editServicio"]);
  }
  
  NuevoServicio(){
    this.router.navigate(["addServicio"]);
  }

  showModalDelete(servicio:Servicio){

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Estas Seguro?',
      text: "No podras Revertir esto!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, Eliminalo!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        swalWithBootstrapButtons.fire(
          
          'Eliminado!',
          'Su servicio fue eliminado.',
          'success'
        )
        this.service.deleteServicio(servicio)
        .subscribe(data=>{
        this.servicios=this.servicios.filter(p=>p!==servicio);
        })
      } else if (
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'Su servicio esta seguro :)',
          'error'
        )
      }
    })
  }

}
