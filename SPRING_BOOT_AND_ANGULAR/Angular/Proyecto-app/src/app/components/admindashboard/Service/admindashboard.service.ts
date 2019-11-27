import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AdmindashboardService {


  constructor(private http:HttpClient) { 
    this.http = http;
  }
  Url='http://localhost:8080';

  getAllUsers(token:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(this.Url+"/users",{headers:headers});
  }

  saveUser(user:any){
    return this.http.post(this.Url+"/registration", user)
   }

}

