import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../interfaces/user';
import {UserService} from '../user.service'

@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {
  name:string;
  username:string;
  password:string;
  country:string;
  gender:string;
  month:string;
  day:string;
  year:string;
  newUser:User;
  constructor(private userService:UserService) { }

  ngOnInit() {
    
  }
  submit(){
    if(this.month.length!=2 || this.year.length!=4 || this.day.length!= 2){

    }else {
      this.newUser = {
        name:this.name,
        username: this.username,
        password: this.password,
        country: this.country,
        gender: this.gender,
        birthday: this.year + "-" + this.month + "-" +this.day
      }
      this.userService.createUser(this.newUser).subscribe((user)=> {
        console.log(user)
      });
    }
    console.log(this.newUser)
  }
}
