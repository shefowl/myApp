package com.example.myApp.ShopClasses.Participants;


import com.example.myApp.ShopClasses.Participants.Enum.ParticipantRoleEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
//@MappedSuperclass
//@Inheritance(strategy=JOINED)

@ToString
@EqualsAndHashCode
//@Entity
//@Inheritance(strategy=JOINED) // почему не создает таблицу админа?
@MappedSuperclass
public class ShopParticipant implements Comparable<ShopParticipant>, Serializable { // должен быть MappedSuperclass

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected int accountId;
    protected String userName;
    protected String password;
    protected boolean active;
    protected Date registrationDate;
    @ElementCollection(targetClass = ParticipantRoleEnum.class, fetch = FetchType.EAGER)
   // @CollectionTable(name = "shop_participant_role", joinColumns = @JoinColumn(name = "shop_participant_id"))
    @Enumerated(EnumType.STRING)
    private Set<ParticipantRoleEnum> role;
    //protected static int id = 0;
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String UserName)
    {
        this.userName = UserName;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String Password)
    {
        this.userName = Password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @JsonCreator
    public ShopParticipant(String userName, String password) {
        this.userName = userName;
        this.password = password;
        Date registrationDate = new Date();
       // this.accountId = ++id;
        this.registrationDate = registrationDate;
    }

    public ShopParticipant() {
    }

    @Override
    public int compareTo(ShopParticipant anotherParticipant) {
        return this.accountId - anotherParticipant.accountId;
    }

    public boolean checkUserName(ShopParticipant anotherParticipant) {
        return this.userName == anotherParticipant.userName;
    }

    public void setRegistrationDate() {
        Date date = new Date();
        this.registrationDate = date;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Set<ParticipantRoleEnum> getRole() {
        return role;
    }

    public void setRole(Set<ParticipantRoleEnum> role) {
        this.role = role;
    }
}
