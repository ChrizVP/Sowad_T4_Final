import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root'
})

export class LoginService {

  constructor(private http:HttpClient) {
    this.http = http;
  }
  Url='http://localhost:8080';


  loginUser(user: any):Observable<any>{
    return this.http.post(this.Url+"/login", user)
  }

}
