package com.ratingserviceapp.Controller;

import com.ratingserviceapp.Entity.Rating;
import com.ratingserviceapp.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/addrating")
    public ResponseEntity<Rating> createRatings(@RequestBody Rating rating){
        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @GetMapping("/allratings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> ratingsByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(ratingService.ratingByHotelId(hotelId));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> ratingsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(ratingService.ratingByUserId(userId));
    }
}
