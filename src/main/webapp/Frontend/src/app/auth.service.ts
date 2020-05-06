import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {User} from './interfaces/user'
import { catchError, map, tap } from 'rxjs/operators';
import { JsonPipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  constructor(private http: HttpClient) { }

  login(username:string, password:string):Observable<User>{  
    let body = `username=${username}&password=${password}`;
    return this.http.post<User>(
      "http://localhost:8080/moviereview/user/login", 
      body, 
      {headers: new HttpHeaders({'Content-Type':  'application/x-www-form-urlencoded'})}
    )
  };
}
