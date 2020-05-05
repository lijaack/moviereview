import { Component, OnInit } from '@angular/core';
import { DataService } from "../data.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  login: boolean = false
  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.currentLoginStatus.subscribe(login => {this.login = login; console.log("my login status is: " + this.login)})
  }
  logout(){
    localStorage.removeItem("username");
    localStorage.removeItem("password");
    this.data.changeLogin(false);
  }

}
