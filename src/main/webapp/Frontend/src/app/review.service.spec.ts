import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ReviewService } from './review.service';

describe('ReviewService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
    providers: [ReviewService]
  }));

  it('should be created', () => {
    const service: ReviewService = TestBed.get(ReviewService);
    expect(service).toBeTruthy();
  });
  it('should have getAllReviews function', () => {
    const service: ReviewService = TestBed.get(ReviewService);
    expect(service.getAllReviews).toBeTruthy();
   });
   it('should have updateReview function', () => {
    const service: ReviewService = TestBed.get(ReviewService);
    expect(service.updateReview).toBeTruthy();
   });
   it('should have createReview function', () => {
    const service: ReviewService = TestBed.get(ReviewService);
    expect(service.createReview).toBeTruthy();
   });

});
