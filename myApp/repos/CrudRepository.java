package com.example.myApp.repos;

import com.example.myApp.ShopClasses.Participants.User;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.repository.MyCrudRepository;

public interface CrudRepository
{
    User creatUser(User account);
    User readUser(String userName);
    User updateUser(User account);
    void deleteUser(String userName);
}
