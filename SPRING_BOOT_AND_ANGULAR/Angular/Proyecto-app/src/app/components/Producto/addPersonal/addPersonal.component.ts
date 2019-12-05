import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonalService } from 'src/app/components/Producto/Service/Personal.service';
import { Personal } from '../Modelo/Personal';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addPersonal',
  templateUrl: './addPersonal.component.html',
  styleUrls: ['./addPersonal.component.css']
})
export class AddPersonalComponent implements OnInit {

  constructor(private router:Router, private service:PersonalService) { }
  personal:Personal = new Personal();
  ngOnInit() {
  }

  GuardarPersonal(){
    if(this.personal.nombre != null && this.personal.apellidos != null){
      this.service.createPersonal(this.personal)
      .subscribe(data=>{
        this.showModal();
        this.router.navigate(["listarPersonal"]);
      })
    }else{
      this.shoModalFallo();
    }
  }

  CancelarNew(){
    this.router.navigate(["listarPersonal"]);
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
