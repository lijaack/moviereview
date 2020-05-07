import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../interfaces/movie';
import {Router} from '@angular/router';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent implements OnInit {
  @Input() movie:Movie;
  image:String;
  constructor(private router: Router) { }

  ngOnInit() {
   this.image = "https://image.tmdb.org/t/p/original"+ this.movie.backdrop_path;
  }
  redirect(){
    this.router.navigate(['/movie/'+this.movie.id]);
  }
}
