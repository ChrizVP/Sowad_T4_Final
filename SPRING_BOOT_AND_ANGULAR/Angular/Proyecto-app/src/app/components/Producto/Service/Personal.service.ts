import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Personal } from '../Modelo/Personal';

@Injectable()

export class PersonalService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:8080/personal';

  getPersonal(){
    return this.http.get<Personal[]>(this.Url);
  }
  createPersonal(personal:Personal){
    return this.http.post<Personal>(this.Url,personal);
  }
  getPersonalId(personal_id:number){
    return this.http.get<Personal>(this.Url+"/"+personal_id);
  }
  updatePersonal(personal:Personal){
    return this.http.put<Personal>(this.Url+"/"+personal.personal_id,personal)
  }
  deletePersonal(personal:Personal){
    return this.http.delete<Personal>(this.Url+"/"+personal.personal_id)
  }
}
