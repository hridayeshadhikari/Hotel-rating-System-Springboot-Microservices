package com.userserviceapp.Controller;

import com.userserviceapp.Entity.User;
import com.userserviceapp.Services.UserService;
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

    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User user1=userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
        User user=userService.getOneUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/alluser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
