package com.userserviceapp.Services.Impl;

import com.userserviceapp.Entity.Hotel;
import com.userserviceapp.Entity.Rating;
import com.userserviceapp.Entity.User;
import com.userserviceapp.Exception.ResourceNotFoundException;
import com.userserviceapp.Repository.UserRepository;
import com.userserviceapp.Services.HotelClient;
import com.userserviceapp.Services.RatingClient;
import com.userserviceapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingClient ratingClient;
    @Autowired
    private HotelClient hotelClient;
    @Override
    public List<User> getAllUser() {
        List<User> users=userRepository.findAll();
        for (User user : users) {
            List<Rating> ratings = ratingClient.ratingByUserId(user.getUserId());
            for (Rating rating : ratings) {
                Hotel hotel = hotelClient.getHotel(String.valueOf(rating.getHotelId()));
                rating.setHotel(hotel);
            }
            user.setRating(ratings);
        }
        return users;
    }

    @Override
    public User getOneUser(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("no user found with the given id "));
        List<Rating> ratings=ratingClient.ratingByUserId(userId);

        for (Rating rating:ratings){
            Hotel hotel=hotelClient.getHotel(String.valueOf(rating.getHotelId()));
            rating.setHotel(hotel);
        }
        user.setRating(ratings);
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


}
