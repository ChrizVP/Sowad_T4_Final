import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CotizacionnewService } from 'src/app/components/cotizacion/serviciow/cotizacionnew.service';
import { Cliente } from 'src/app/components/Cliente/Modelo/Cliente';
import { Personal } from 'src/app/components/Producto/Modelo/Personal';
import { ServicioMecanicoCab } from '../../Modelo/ServicioMecanicoCab';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cotizacionnew',
  templateUrl: './cotizacionnew.component.html',
  styleUrls: ['./cotizacionnew.component.css']
})
export class CotizacionnewComponent implements OnInit {

  clientes:Cliente[];
  cliente:Cliente;
  personal:Personal;
  cliente_id:number;
  personal_id:number;
  personals:Personal[];
  dateDay = new Date();
  servicioMecanicoCab:ServicioMecanicoCab = new ServicioMecanicoCab();
  constructor(private router:Router, private service:CotizacionnewService) { }

  ngOnInit() {
    this.ListarCliente();
    this.ListarPersonal();
  }

  ListarCliente() {
    this.service.listadoCliente()
    .subscribe(data=>{
      this.clientes=data;
    })
  }

  ListarPersonal() {
    this.service.listadoPersonal()
    .subscribe(data=>{
      this.personals=data;
    })
  }

  NuevoServicio(cliente_id:number, personal_id:number, fecha:Date){

    let date = new Date(fecha);
    let fechaSave = new Date(date);
    localStorage.setItem("cliente_id",cliente_id.toString());
    let cliente_idd=localStorage.getItem("cliente_id");
    localStorage.setItem("personal_id",personal_id.toString());
    let personal_idd=localStorage.getItem("personal_id");

    if(( date.getUTCDate() >= this.dateDay.getDate() ) && ( (date.getUTCMonth()+1) >= (this.dateDay.getUTCMonth()+1) ) ){
      fechaSave.setDate(date.getUTCDate());
      this.servicioMecanicoCab.fecha = fechaSave;
      this.service.nuevoServicio(+cliente_idd, +personal_idd, this.servicioMecanicoCab)
      .subscribe(data=>{
      this.router.navigate(["addcotizacion"]);
      })

    }else{
      this.showModalFechaNoValida();
    }
    
    
  }


  showModalFechaNoValida(){
    Swal.fire({
      position: 'center',
      type: 'error',
      title: 'Fecha No Valida!',
      showConfirmButton: false,
      timer: 1500
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

}
