package com.exposit.carsharing.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
