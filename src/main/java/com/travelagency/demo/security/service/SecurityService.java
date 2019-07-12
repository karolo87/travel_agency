package com.travelagency.demo.security.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String login, String password);
}
