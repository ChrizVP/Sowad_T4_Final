import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonalService } from 'src/app/components/Producto/Service/Personal.service';
import { Personal } from '../../Producto/Modelo/Personal';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editPersonal',
  templateUrl: './editPersonal.component.html',
  styleUrls: ['./editPersonal.component.css']
})
export class EditPersonalComponent implements OnInit {

  personal:Personal = new Personal();
  constructor(private router:Router, private service:PersonalService) { }

  ngOnInit() {
    this.EditarPersonal();
  }

  EditarPersonal(){
    let personal_id=localStorage.getItem("personal_id");
    this.service.getPersonalId(+personal_id)
    .subscribe(data=>{
      this.personal=data;
    })
  }

  CancelarEdition(){
    this.router.navigate(["listarPersonal"]);
  }

  ActualizarPersonal(personal:Personal){
    
    this.service.updatePersonal(personal)
    .subscribe(data=>{
      this.personal=data;
      this.showModal();
      this.router.navigate(["listarPersonal"]);
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
