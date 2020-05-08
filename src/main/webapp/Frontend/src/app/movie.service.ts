import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {Movie} from './interfaces/movie';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private trendingMovie = 'https://api.themoviedb.org/3/trending/movie/week?api_key=24991af107f15c42f95f9e9b1f7073b6'; 
  constructor(private http: HttpClient) { }
  
  getTopMovies():Observable<Movie[]>{
    
    return this.http.get<Movie[]>(this.trendingMovie);
  };
  searchMovie(movieName:string):Observable<Movie[]>{
    let movieAPI = 'https://api.themoviedb.org/3/search/movie?api_key=24991af107f15c42f95f9e9b1f7073b6&language=en-US&query='+movieName+'&page=1&include_adult=false'; 
    return this.http.get<Movie[]>(movieAPI);
  };
  getMovieByID(id:number):Observable<Movie>{
    
    return this.http.get<Movie>("https://api.themoviedb.org/3/movie/"+ id +"?api_key=24991af107f15c42f95f9e9b1f7073b6&language=en-US");
  }


}
