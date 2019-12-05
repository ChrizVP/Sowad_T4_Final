import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TopbarService {

  constructor(private http:HttpClient) { 
    this.http = http;
  }

  Url='http://localhost:8080';

  getUser(token:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(this.Url+"/getuser",{headers:headers});
  }
}
