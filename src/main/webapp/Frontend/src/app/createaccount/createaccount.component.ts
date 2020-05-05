import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../interfaces/user';
import {UserService} from '../user.service'
import { DataService } from "../data.service";

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
  constructor(private userService:UserService, private data: DataService) { }

  ngOnInit() {
    
  }
  submit(){
    this.error=null;
    if(this.month.length!=2 || this.year.length!=4 || this.day.length!= 2){
      this.error = "invalid date format"
    }else {
      this.newUser = {
        name:this.name,
        username: this.username,
        password: this.password,
        country: this.country,
        gender: this.gender,
        birthday: this.year + "-" + this.month + "-" +this.day
      }
      this.userService.createUser(this.newUser).subscribe(
        data => {
          //if success, store user data and state
          this.data.changeLogin(true);
          console.log("data"); console.log(data)

        },
        error => {
          this.error=error.error; 
        }
      );
    }
  }
}
