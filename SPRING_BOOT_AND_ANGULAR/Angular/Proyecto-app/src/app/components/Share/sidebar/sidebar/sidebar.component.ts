import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {SidebarService} from '../service/sidebar.service';
import {LoginAuthService} from 'src/app/components/Login/Service/login-auth.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  public loginuser:any = {};
  public user:any={};

  constructor(private router:Router, private sidebarService:SidebarService, private loginAuthService:LoginAuthService ) {
    this.loginAuthService.isLogeedIn();
    this.loginuser = JSON.parse(localStorage.getItem('currentUser'));
    this.getUser();
   }

  ngOnInit() {
    
  }
  ListarCliente(){
    this.router.navigate(["listarCliente"]);
  }
  
  ListarPersonal(){
    this.router.navigate(["listarPersonal"]);
  }

  ListarServicio(){
    this.router.navigate(["listarServicio"]);
  }

  Cotizacion(){
    this.router.navigate(["cotizacionnew"]);
  }

  ListarUsuarios(){
    this.router.navigate(["admindashboard"]);
  }

  AgregarUsuario(){
    this.router.navigate(["signup"]);
  }

  NuevaCotizacion(){
    this.router.navigate(["cotizacionnew"]);
  }

  ReportarCotizacion(){
    this.router.navigate(["reportcotizacion"]);
  }

  getUser(){
    this.sidebarService.getUser(this.loginuser.token).subscribe(user =>{
      this.user = user;
    })
  }
  
}
