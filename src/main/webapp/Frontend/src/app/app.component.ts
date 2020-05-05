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
    this.data.changeLogin(true);
  }



}
