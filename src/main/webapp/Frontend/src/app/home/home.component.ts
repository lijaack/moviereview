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
  searchField:string;
  movieType:string;
  constructor(private movieService:MovieService) { }

  ngOnInit() {
    this.getTopMovies()
  }
  getTopMovies(){
    this.movieService.getTopMovies()
    .subscribe((movies)=> {
      this.movieType="Trending Movies";
      this.movies = movies;
      this.movieResults = this.movies.results
    })
  }
  searchMovie(){
    this.movieService.searchMovie(this.searchField)
    .subscribe((movies)=> {
      this.movieType="Results for " + this.searchField;
      this.movies = movies;
      this.movieResults = this.movies.results
      console.log(this.movieResults)
    })
  }
}
