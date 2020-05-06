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
        this.authService.login(this.username, this.password).subscribe(
          data => {
            console.log(data)
            //if success, store user data and reroute
            localStorage.setItem('username', data.username);
            localStorage.setItem('password',data.password);
            localStorage.setItem('userid',data.id.toString());
            this.data.changeLogin(true);
            this.router.navigate(["/dashboard"]);
          },
          error => {
            console.log(error)
            this.error=error.error; 
          }
        );
      }else{
        this.error="invalid information";
      }
    
  }

}
