import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MovieService } from './movie.service';

describe('MovieService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
    providers: [MovieService]
  }));

  it('should be created', () => {
    const service: MovieService = TestBed.get(MovieService);
    expect(service).toBeTruthy();
  });

  it('should have getMovieByID function', () => {
    const service: MovieService = TestBed.get(MovieService);
    expect(service.getMovieByID).toBeTruthy();
   });
   it('should have getTopMovies function', () => {
    const service: MovieService = TestBed.get(MovieService);
    expect(service.getTopMovies).toBeTruthy();
   });
   it('should have searchMovie function', () => {
    const service: MovieService = TestBed.get(MovieService);
    expect(service.searchMovie).toBeTruthy();
   });
});
