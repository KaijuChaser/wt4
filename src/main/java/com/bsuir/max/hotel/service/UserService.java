package com.bsuir.max.hotel.service;

import com.bsuir.max.hotel.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsernameAndPassword(String username, String password) throws ServiceException;

    Optional<User> findById(Integer id) throws ServiceException;

    Optional<User> findByUsername(String username) throws ServiceException;

    void signUpUser(Integer id, String username, String password) throws ServiceException;
}
