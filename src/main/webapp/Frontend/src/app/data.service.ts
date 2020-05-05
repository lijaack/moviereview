import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private loginStatus = new BehaviorSubject(false);
  currentLoginStatus = this.loginStatus.asObservable();

  constructor() { }

  changeLogin(login: boolean) {
    this.loginStatus.next(login)
  }

}
