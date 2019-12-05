import { Component, OnInit } from '@angular/core';
import {AdmindashboardService} from 'src/app/components/admindashboard/Service/admindashboard.service';
import { LoginAuthService } from 'src/app/components/Login/Service/login-auth.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user:any ={};

  constructor(private router:Router, private admindashboardService:AdmindashboardService, private loginAuthService:LoginAuthService) {
    this.loginAuthService.isLogeedIn();
   }

  ngOnInit() {
  }

    SaveUser(user:any, userForm:any){
      this.admindashboardService.saveUser(user).subscribe((response) => {
        if(response){
          console.log(response);  
          this.showModal();
          userForm.reset();
        }
      })
  }

  Cancelar(){
    this.router.navigate(["home"]);
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
