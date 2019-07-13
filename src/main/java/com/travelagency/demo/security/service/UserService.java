package com.travelagency.demo.security.service;

import com.travelagency.demo.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    void save(User user);

    User findByUserName(String userName);
}
