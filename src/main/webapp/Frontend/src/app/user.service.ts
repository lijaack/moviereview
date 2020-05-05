import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {User} from './interfaces/user'
import { catchError, map, tap } from 'rxjs/operators';
import { JsonPipe } from '@angular/common';

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
    return this.http.post<User>("http://localhost:8080/moviereview/user/newUser", JSON.stringify(user), this.httpOptions)
  };
}
