import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../interfaces/user';
import {UserService} from '../user.service'
import { DataService } from "../data.service";
import {Router} from "@angular/router"
@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {
  name:string = null;
  username:string = null;
  password:string = null;
  country:string = null;
  gender:string = null;
  month:string = "";
  day:string = "";
  year:string = "";
  newUser:User = null;
  error:string = null;
  constructor(private userService:UserService, private data: DataService, private router: Router) { }

  ngOnInit() {
    
  }
  submit(){
    this.error=null;
    if(this.month.trim().length!=2 || this.year.trim().length!=4 || this.day.trim().length!= 2){
      this.error = "invalid date format"
    }else {
      this.newUser = {
        name:this.name.trim(),
        username: this.username.trim(),
        password: this.password.trim(),
        country: this.country.trim(),
        gender: this.gender.trim(),
        birthday: this.year.trim() + "-" + this.month.trim() + "-" +this.day.trim()
      }
      this.userService.createUser(this.newUser).subscribe(
        data => {
          //if success, store user data and reroute
          localStorage.setItem('username', data.username);
          localStorage.setItem('password',data.password);
          localStorage.setItem('userid',data.id.toString());
          this.data.changeLogin(true);
          this.router.navigate(["/dashboard"]);
        },
        error => {
          this.error=error.error; 
        }
      );
    }
  }
}
