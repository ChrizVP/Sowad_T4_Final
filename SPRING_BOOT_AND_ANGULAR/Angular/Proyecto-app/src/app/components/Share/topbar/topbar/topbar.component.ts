import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginAuthService} from 'src/app/components/Login/Service/login-auth.service';
import {TopbarService} from 'src/app/components/Share/topbar/service/topbar.service'
import { User } from 'src/app/components/Login/Modelo/User';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {

  public Currentstatus:any;
  public loginuser:any = {};
  public user:User;

  constructor(private router:Router, private loginAuthService:LoginAuthService, private topbarService:TopbarService){
    
    this.Currentstatus = this.loginAuthService.getStatus().subscribe(currentstatus =>{
      this.Currentstatus = currentstatus;
    });

    this.loginAuthService.isLogeedIn();
    this.loginuser = JSON.parse(localStorage.getItem('currentUser'));
    if(this.user ==null){
      this.getUser();
    }
    
  }

  ngOnInit() {
  }

  Logout(){
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
    
  }

  getUser(){
    this.topbarService.getUser(this.loginuser.token).subscribe(user =>{
      this.user = user;
      
    })
  }


}
