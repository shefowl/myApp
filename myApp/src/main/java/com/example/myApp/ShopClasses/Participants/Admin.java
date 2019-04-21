package com.example.myApp.ShopClasses.Participants;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;

@Entity
public class Admin extends ShopParticipant {
    @JsonCreator
    public Admin(String userName, String password) {
        super(userName, password);
    }

    public Admin() {
        super();
    }
}
