package com.userserviceapp.Services;

import com.userserviceapp.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingClient {
    @GetMapping("rating/user/{userId}")
    List<Rating> ratingByUserId(@PathVariable("userId") Long userId);
}
