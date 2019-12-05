import { Component, OnInit } from '@angular/core';
import {LoginAuthService} from 'src/app/components/Login/Service/login-auth.service';
import {AdmindashboardService} from '../Service/admindashboard.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  public loginuser:any={};
  public users:any = [];

  constructor(private router:Router, private loginAuthService:LoginAuthService, private admindashboardService:AdmindashboardService) { 
    this.loginAuthService.isLogeedIn();
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.admindashboardService.getAllUsers(this.loginuser.token).subscribe(users=>{
      this.users = users;
    })
  }

  NuevoUsuario(){
    this.router.navigate(["signup"]);
  }
  
}
