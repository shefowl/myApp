package com.example.myApp.repository;

import com.example.myApp.ShopClasses.Participants.User;
//import org.springframework.data.repository.CrudRepository;

public interface CrudRepository
{
    User creatUser(User account);
    User readUser(String userName);
    User updateUser(User account);
    void deleteUser(String userName);
}
