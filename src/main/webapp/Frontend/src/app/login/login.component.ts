import { Component, OnInit } from '@angular/core';
import { DataService } from "../data.service";
import {User} from '../interfaces/user';
import {AuthService} from '../auth.service'
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username:string = null;
  password:string = null;
  error:string = null;
  constructor(private authService:AuthService, private data: DataService, private router: Router) { }

  ngOnInit() {
  }

  submit(){
      if(this.username && this.password){

      }else{
        this.error="invalid information";
      }
    
  }

}
