package com.userserviceapp.Services;

import com.userserviceapp.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();
    User getOneUser(Long userId);
    User createUser(User user);

}
