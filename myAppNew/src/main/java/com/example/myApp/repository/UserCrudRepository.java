package com.example.myApp.repository;

import com.example.myApp.ShopClasses.Participants.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserCrudRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
