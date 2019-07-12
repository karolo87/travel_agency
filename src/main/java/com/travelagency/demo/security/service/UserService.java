package com.travelagency.demo.security.service;

import com.travelagency.demo.security.model.User;

public interface UserService {

    void save(User user);

    User findByUserName(String userName);
}
