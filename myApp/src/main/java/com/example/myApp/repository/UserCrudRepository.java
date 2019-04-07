package com.example.myApp.repository;

import com.example.myApp.ShopClasses.Participants.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepository implements CrudRepository {

    @Override
    public User creatUser(User account) {
        return null;
    }

    @Override
    public User readUser(String userName) {
        return null;
    }

    @Override
    public User updateUser(User account) {
        return null;
    }

    @Override
    public void deleteUser(String userName) {

    }
}
