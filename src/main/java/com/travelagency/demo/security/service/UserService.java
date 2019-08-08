package com.travelagency.demo.security.service;

import com.travelagency.demo.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    void save(User user);

    User findByUserName(String userName);

    List<User> getAllUsers();

}
