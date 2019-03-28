package com.example.myApp.service;

import com.example.myApp.ShopClasses.Participants.User;
import com.example.myApp.repos.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceImpl implements AbstractService {
    private final CrudRepository repository;

    @Autowired
    public ServiceImpl(CrudRepository repository){
        this.repository = repository;
    }

    private static final Map<String, User> UserMap = new HashMap<String, User>();

    public User creatUser(User account)
    {
        repository.creatUser(account);
        UserMap.put(account.getUserName(), account);
        return account;
    }

    public User readUser(String userName)
    {
        return UserMap.get(userName);
    }

    public User updateUser(User account)
    {
        UserMap.put(account.getUserName(), account);
        return account;
    }

    public void deleteUser(String userName)
    {
        UserMap.remove(userName);
    }

    public List<User> getAllUsers()
    {
        Collection<User> c = UserMap.values();
        List<User> list = new ArrayList<User>();
        list.addAll(c);
        return list;
    }
}
