package com.userserviceapp.Services.Impl;

import com.userserviceapp.Entity.User;
import com.userserviceapp.Exception.ResourceNotFoundException;
import com.userserviceapp.Repository.UserRepository;
import com.userserviceapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUser(Long userId) {
        Optional<User> getUser=userRepository.findById(userId);
        if(getUser.isEmpty()){
            throw new ResourceNotFoundException("no user found with the id "+userId);
        }
        return getUser.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
