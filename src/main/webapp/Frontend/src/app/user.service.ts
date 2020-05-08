import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from './interfaces/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  }
  constructor(private http: HttpClient) { }
  
  createUser(user:User):Observable<User>{    
    return this.http.post<User>("http://3.101.75.179:8085/moviereview/user/newUser", JSON.stringify(user), this.httpOptions)
  };
}
