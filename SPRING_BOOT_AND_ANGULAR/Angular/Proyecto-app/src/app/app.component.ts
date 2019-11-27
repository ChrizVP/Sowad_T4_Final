import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {LoginAuthService} from '../app/components/Login/Service/login-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Proyecto-app';

  public Currentstatus:any;

  constructor(private router:Router, private loginAuthService:LoginAuthService){
    this.Currentstatus = this.loginAuthService.getStatus().subscribe(currentstatus =>{
      this.Currentstatus = currentstatus;
    })
  }

  ListarCliente(){
    this.router.navigate(["listarCliente"]);
  }
  NuevoCliente(){
    this.router.navigate(["addCliente"]);
  }
  EditarCliente(){
    this.router.navigate(["editCliente"]);
  }

  ListarPersonal(){
    this.router.navigate(["listarPersonal"]);
  }
  NuevoPersonal(){
    this.router.navigate(["addPersonal"]);
  }
  EditarPersonal(){
    this.router.navigate(["editPersonal"]);
  }
  Venta(){
    this.router.navigate(["save-venta"]);
  }
}
