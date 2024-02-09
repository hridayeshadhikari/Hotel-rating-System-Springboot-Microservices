package com.ratingserviceapp.Service;

import com.ratingserviceapp.Entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> ratingByUserId(Long userId);
    List<Rating> ratingByHotelId(Long hotelId);
    List<Rating> getAllRating();
}
