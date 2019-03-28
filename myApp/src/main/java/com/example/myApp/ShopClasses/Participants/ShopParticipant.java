package com.example.myApp.ShopClasses.Participants;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@EqualsAndHashCode
public abstract class ShopParticipant implements Comparable<ShopParticipant>, Serializable
{
//    @Getter
//    @Setter
    protected String userName;
//    @Getter
//    @Setter
    protected String password;

    //    @Getter
//    @Setter
    protected int accountId;
//    @Getter
//    @Setter
    protected Date registrationDate;
    protected static int id = 0;

    public ShopParticipant(String userName, String password)
    {
        Date registrationDate = new Date();
        this.userName = userName;
        this.password = password;
        this.accountId = ++id;
        this.registrationDate = registrationDate;
    }

    @Override
    public int compareTo(ShopParticipant anotherParticipant)
    {
        return this.accountId - anotherParticipant.accountId;
    }

    public boolean checkUserName(ShopParticipant anotherParticipant)
    {
        return this.userName == anotherParticipant.userName;
    }

    public void setUserName(String UserName)
    {
        this.userName = UserName;
    }

    public void setPassword(String Password)
    {
        this.userName = Password;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }


}
