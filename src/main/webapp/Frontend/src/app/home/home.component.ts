import { Component, OnInit } from '@angular/core';
import {MovieService} from '../movie.service'
import { Movie } from '../interfaces/movie';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  movies;
  movieResults:Movie[];
  constructor(private movieService:MovieService) { }

  ngOnInit() {
    this.getTopMovies()
  }
  getTopMovies(){
    this.movieService.getTopMovies()
    .subscribe((movies)=> {
      this.movies = movies;
      this.movieResults = this.movies.results
      console.log(this.movieResults)
    })
  }
}
