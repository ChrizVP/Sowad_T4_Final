import { Component, OnInit } from '@angular/core';
import {LoginAuthService} from '../Login/Service/login-auth.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private loginAuthService:LoginAuthService) {
    this.loginAuthService.isLogeedIn();
   }

  ngOnInit() {
  }

}
