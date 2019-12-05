import { Component, OnInit } from '@angular/core';
import{PersonalService}from'src/app/components/Producto/Service/Personal.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Personal } from '../Modelo/Personal';

@Component({
  selector: 'app-listarPersonal',
  templateUrl: './listarPersonal.component.html',
  styleUrls: ['./listarPersonal.component.css']
})
export class ListarPersonalComponent implements OnInit {

  personals:Personal[];
  constructor(private service:PersonalService, private router:Router) { }

  ngOnInit() {
    this.service.getPersonal()
    .subscribe(data=>{
      this.personals=data;
    })
  }

  EditarPersonal(personal:Personal):void{
    localStorage.setItem("personal_id",personal.personal_id.toString());
    this.router.navigate(["editPersonal"]);
  }
  
  NuevoPersonal(){
    this.router.navigate(["addPersonal"]);
  }

  showModalDelete(personal:Personal){

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
          'Su producto fue eliminado.',
          'success'
        )
        this.service.deletePersonal(personal)
        .subscribe(data=>{
        this.personals=this.personals.filter(p=>p!==personal);
        })
      } else if (
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'Su personal esta seguro :)',
          'error'
        )
      }
    })
  }


}
