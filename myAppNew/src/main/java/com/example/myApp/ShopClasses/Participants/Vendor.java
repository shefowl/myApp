package com.example.myApp.ShopClasses.Participants;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor  extends ShopParticipant{
    private String address;
    private String description;

    public Vendor() {
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonCreator
    public Vendor(String userName, String password, String address, String description) {
        super(userName,password);
        this.address = address;
        this.description = description;
    }
}
