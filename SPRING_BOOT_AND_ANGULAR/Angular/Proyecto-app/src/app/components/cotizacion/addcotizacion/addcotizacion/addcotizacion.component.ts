import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CotizacionnewService } from 'src/app/components/cotizacion/serviciow/cotizacionnew.service';
import { ServicioMecanicoDet } from '../../Modelo/ServicioMecanicoDet';
import { Servicio } from '../../Modelo/Servicio';
import { ServicioMecanicoCab } from '../../Modelo/ServicioMecanicoCab';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-addcotizacion',
  templateUrl: './addcotizacion.component.html',
  styleUrls: ['./addcotizacion.component.css']
})
export class AddcotizacionComponent implements OnInit {

  servicioMecanicoDets:ServicioMecanicoDet[];
  saveCotizacion:Boolean;
  servicios:Servicio[];
  servicio:Servicio;
  servicio_id:number;
  servicioMecanicoCab:ServicioMecanicoCab;
  servicioMecanicoDet:ServicioMecanicoDet = new ServicioMecanicoDet();
  constructor(private router:Router, private service:CotizacionnewService) { }
  

  ngOnInit() {
    this.ListarServicio();
    this.ListarServicioDet();
  }


  ListarServicio() {
    this.service.listadoServicio()
    .subscribe(data=>{
      this.servicios=data;
    })
  }
  ListarServicioDet(){
    this.service.listadoServicioMecanicoDet().
    subscribe(data=>{
      this.servicioMecanicoDets=data;
    })
  }

  AddServicioMecanicoDet(servicio_id:number){
  
    localStorage.setItem("servicio_id",servicio_id.toString());
    let servicio_id_save=localStorage.getItem("servicio_id");
    if(this.servicioMecanicoDet.contenido == null || this.servicioMecanicoDet.marca == null || 
      this.servicioMecanicoDet.modelo == null || this.servicioMecanicoDet.placa == null){
        this.shoModalFaltaDatos();
    }else{
      this.service.addServicioMecanicoDet(+servicio_id_save,this.servicioMecanicoDet)
      .subscribe(data=>{
          this.servicioMecanicoDets=data; 
      })
      this.showModalAgregar();
      this.servicioMecanicoDet = new ServicioMecanicoDet();
    }

  }

  RemoveServicioMecanicoDet(servicioMecanicoDet:ServicioMecanicoDet){
    localStorage.setItem("servicioDet_id",servicioMecanicoDet.servicioDet_id.toString());
    let servicioDet_id=localStorage.getItem("servicioDet_id");
    this.service.removeServicioMecanicoDet(+servicioDet_id)
    .subscribe(data=>{
      this.servicioMecanicoDets=data; 
    })
  }

  SaveServicioMecanicoDet(){
    this.service.saveServicioMecanicoDet()
    .subscribe(data=>{
      this.saveCotizacion=data;
      if(this.saveCotizacion == true){
        this.showModalSaveCotizacion();
        this.router.navigate(["home"]);
      }else{
        this.showModalNoHayDetalle();
      }
    })
  }

  CancelServicioMecanicoDet(){
    this.service.cancelServicioMecanicoDet()
    .subscribe(data=>{
      this.servicioMecanicoCab = data;
      this.router.navigate(["cotizacionnew"]);
    })
  }

  showModalAgregar(){
    Swal.fire({
      position: 'center',
      type: 'success',
      title: 'Agregado con Exito!',
      showConfirmButton: false,
      timer: 900
    });
  }

  showModalSaveCotizacion(){
    Swal.fire({
      position: 'center',
      type: 'success',
      title: 'Cotizacion Creada con Exito!',
      showConfirmButton: false,
      timer: 900
    });
  }

  shoModalFaltaDatos(){
    Swal.fire({
    position: 'center',
    type: 'error',
    title: 'Faltan Datos!',
    showConfirmButton: false,
    timer: 1300
  });
}

  showModalNoHayDetalle(){
    Swal.fire({
      position: 'center',
      type: 'error',
      title: 'No Hay Detalle De Servicios!',
      showConfirmButton: false,
      timer: 1000
    });
  }

  showModalDelete(){

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Estas Seguro Que Deseas Salir?',
      text: "No Podras Revertir Esto!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, Salir!',
      cancelButtonText: 'No, Mantenerse!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        swalWithBootstrapButtons.fire(
          
          'Cancelado!',
          'Su Cotizacion Fue Cancelada.',
          'success'
        )
        this.service.cancelServicioMecanicoDet()
        .subscribe(data=>{
        this.servicioMecanicoCab = data;
        this.router.navigate(["cotizacionnew"]);
        })
      } else if (
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'Tu Cotizacion Esta Segura :)',
          'error'
        )
      }
    })
  }


}
