import { Component, OnInit } from '@angular/core';
import {MovieService} from '../movie.service'
import { Movie } from '../interfaces/movie';
import { ActivatedRoute } from "@angular/router";
import { DataService } from "../data.service";
import {Review} from '../interfaces/review';
import {ReviewService} from '../review.service'

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})

export class MovieComponent implements OnInit {
  movie:Movie;
  movieTitle:string;
  id:number;
  image:string;
  newReviewForm:boolean = false;
  login:boolean = false
  movieScore:number;
  movieOverview:string;
  reviewText:string;
  review:Review;
  error:string;
  constructor(private reviewService:ReviewService, private movieService:MovieService, private route: ActivatedRoute, private data: DataService) { }
  
  ngOnInit() {
    this.id = parseInt(this.route.snapshot.paramMap.get("id"));
    this.getMovie(this.id);
    this.data.currentLoginStatus.subscribe(login => {this.login = login;})
  }
  getMovie(id:number){
    this.movieService.getMovieByID(id)
    .subscribe((movie)=> {
      this.movie=movie;
      this.movieTitle = movie.title;
      this.movieOverview = movie.overview
      this.image =  "https://image.tmdb.org/t/p/original"+ this.movie.poster_path;
    })
  }
  newReviewButton(){
    this.newReviewForm = !this.newReviewForm;
  }
  submitReview(){
    this.error = null;
    console.log(
      this.review
    )
    if(this.movieScore && this.reviewText){
      this.review = {
        review:this.reviewText,
        movieScore:this.movieScore,
        dateCreated: new Date().toISOString().slice(0,10).toString(),
        movieID: this.movie.id.toString(),
        userID: localStorage.getItem("userid")
      }
      this.reviewService.createReview(this.review).subscribe(
        data => {
          console.log(data)
        },
        error => {
          console.log(error)
          this.error=error.error; 
        }
      );
    } else{
      this.error="incomplete form"
    }
  }
}
