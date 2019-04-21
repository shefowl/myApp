package com.example.myApp.ShopClasses.Participants;

import com.example.myApp.ShopClasses.Buy.CartImpl;
import com.example.myApp.ShopClasses.Buy.Product;
import com.example.myApp.ShopClasses.Participants.Enum.ParticipantRoleEnum;
import com.example.myApp.exeptions.EmptyCartException;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class User extends ShopParticipant {
    //@Embedded
    //CartImpl myCart = new CartImpl();
    private String email;
    @JsonCreator
    public User(String userName, String password, String email) {
        super(userName, password);
        this.email = email;
    }
//    public void addToMyCart(Product chosenProduct){
//        myCart.addToList(chosenProduct);
//    }
//    public void showTheCatalog(){
//
//    }
//    public List<Product> showMyCart() throws EmptyCartException{
//        if(this.myCart.isEmpty()){
//            throw new EmptyCartException();
//        }
//       return myCart.showAllList();
//    }

    public void buy(){

    }

    public User() {
        super();
    }
}
