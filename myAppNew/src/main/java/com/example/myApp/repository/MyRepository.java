package com.example.myApp.repository;

import com.example.myApp.ShopClasses.Participants.ShopParticipant;
import org.springframework.stereotype.Repository;
//import com.example.myApp.ShopClasses.Participants.User;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface MyRepository {
    ShopParticipant creatUser(ShopParticipant account);
    ShopParticipant readUser(String userName);
    ShopParticipant updateUser(ShopParticipant account);
    void deleteUser(String userName);
}
