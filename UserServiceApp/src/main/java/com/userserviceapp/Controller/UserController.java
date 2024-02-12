package com.userserviceapp.Controller;

import com.userserviceapp.Entity.User;
import com.userserviceapp.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User user1=userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
        User user=userService.getOneUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(Long userId,Exception exp){
        logger.info("Service is down therefore fallback is executed",exp.getMessage());
        exp.printStackTrace();
        User user=User.builder()
                .email("email@gmsil.com")
                .name("default")
                .about("service is down at the movement")
                .userId(4L)
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/alluser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
