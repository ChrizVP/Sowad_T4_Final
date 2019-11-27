import { Component, OnInit } from '@angular/core';
import {AdmindashboardService} from 'src/app/components/admindashboard/Service/admindashboard.service';
import { LoginAuthService } from 'src/app/components/Login/Service/login-auth.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user:any ={};

  constructor(private admindashboardService:AdmindashboardService, private loginAuthService:LoginAuthService) {
    this.loginAuthService.isLogeedIn();
   }

  ngOnInit() {
  }

    SaveUser(user:any, userForm:any){
      this.admindashboardService.saveUser(user).subscribe((response) => {
        if(response){
          console.log(response);  
          userForm.reset();
        }
      })
  }
}
