import { Component, OnInit } from '@angular/core';
import {MovieService} from '../movie.service'
import { Movie } from '../interfaces/movie';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
   movie:Movie;
   id:number;
   image:string;
   newReviewForm:boolean = false;
  constructor(private movieService:MovieService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = parseInt(this.route.snapshot.paramMap.get("id"));
    this.getMovie(this.id);
  }
  getMovie(id:number){
    this.movieService.getMovieByID(id)
    .subscribe((movie)=> {
      this.movie = movie;
      this.image =  "https://image.tmdb.org/t/p/original"+ this.movie.poster_path;
    })
  }
  newReviewButton(){
    this.newReviewForm = !this.newReviewForm;
  }
}
