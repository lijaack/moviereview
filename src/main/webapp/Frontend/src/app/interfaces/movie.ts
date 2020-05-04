import {BaseMovie} from './base-movie';
export class Movie implements BaseMovie{
    adult: boolean;
    backdrop_path: string;
    genre_ids:[number];
    id: number;
    media_type: string;
    original_language: string;
    original_title: string;
    overview: string;
    popularity: number;
    poster_path: string;
    release_date: string;
    title: string;
    video: boolean;
    vote_average: number;
    vote_count: number;
    constructor(movie:BaseMovie) {
        this.id = movie.id;
        this.title = movie.title;
        this.poster_path = movie.poster_path;
        this.backdrop_path = movie.backdrop_path;
  }
}
  