package com.ratingserviceapp.Repository;

import com.ratingserviceapp.Entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,Long> {

    List<Rating> findByUserId(Long userId);
    List<Rating> findByHotelId(Long hotelId);
}
