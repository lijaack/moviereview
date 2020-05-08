import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {Movie} from './interfaces/movie';
import {Review} from './interfaces/review'
@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  
  constructor(private http: HttpClient) { }
  
  createReview(review:Review):Observable<Review>{
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    return this.http.post<Review>("http://3.101.75.179:8085/moviereview/review/newReview", JSON.stringify(review), httpOptions)
  };

  getAllReviews(movieID):Observable<Review[]>{
    let body = `movieID=${movieID}`;
    return this.http.post<Review[]>(
      "http://3.101.75.179:8085/moviereview/review/getByMovieID", 
      body,
      {headers: new HttpHeaders({'Content-Type':  'application/x-www-form-urlencoded'})}
    )
  }
  updateReview(review:Review):Observable<Review>{
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    return this.http.post<Review>("http://3.101.75.179:8085/moviereview/review/updateReview", JSON.stringify(review), httpOptions)
  };
}
