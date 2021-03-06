import { Component } from '@angular/core';
import { DataService } from "./data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-movie-review';
  constructor(private data: DataService) { }

  ngOnInit() {
    if(localStorage.getItem("username") && localStorage.getItem("password")&& localStorage.getItem("userid")){
      this.data.changeLogin(true);
    }
    else{
      this.data.changeLogin(false);
    }
  }

}
