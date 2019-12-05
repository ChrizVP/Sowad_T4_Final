import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router';
import {LoginAuthService} from '../Service/login-auth.service';
import { User } from '../Modelo/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  condicion:boolean;
  getUser:boolean;
  public user: any= {};
  constructor(private service:LoginService, private router:Router, private loginAuthService:LoginAuthService) {
    this.loginAuthService.isLogeedIn();
   }

  ngOnInit() {
  }


  LoginUser(user:any){
    
    this.service.loginUser(user).subscribe((response)=>{
      if(response){
        if(response.token){
          localStorage.setItem('currentUser',JSON.stringify(response));
          this.condicion = true;
          if(response.user.role =='ADMIN'){
            this.router.navigate(['/home'])
         }else{
            this.router.navigate(['/home'])
         }
        }
      }
    }) 

    if(this.condicion == true){
      this.getUser = true;
    }else{
      this.router.navigate(['/login']);
      this.getUser = false;
      this.user ={};
    }
  } 
  

}
