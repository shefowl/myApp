package com.example.myApp.service;

import com.example.myApp.ShopClasses.Buy.Product;
import com.example.myApp.ShopClasses.Participants.User;
import com.example.myApp.exeptions.EntityNotFoundException;
import com.example.myApp.exeptions.SuchUserAlreadyExistException;
import com.example.myApp.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@Service
public class ServiceImpl implements AbstractService {
    private final CrudRepository repository;

    @Autowired
    public ServiceImpl(CrudRepository repository){
        this.repository = repository;
    }

    private static final Map<String, User> UserMap = new HashMap<String, User>();
    @ResponseStatus(HttpStatus.CREATED)
    public User creatUser(User account) {
        if(UserMap.containsKey(account.getUserName())) {
            throw new SuchUserAlreadyExistException();
        }
        repository.creatUser(account);
        UserMap.put(account.getUserName(), account);
        return account;
    }

    public User readUser(String userName) throws EntityNotFoundException
    {
        return UserMap.get(userName);
    }

    public User updateUser(User account) {
        if(!UserMap.containsKey(account.getUserName())) {
            throw new EntityNotFoundException();
        }
        UserMap.put(account.getUserName(), account);
        return account;
    }

    public void deleteUser(String userName) throws EntityNotFoundException{
        if(UserMap.remove(userName) == null){
            throw new EntityNotFoundException();
        }
    }

    public List<User> getAllUsers() {
        Collection<User> c = UserMap.values();
        List<User> list = new ArrayList<User>();
        list.addAll(c);
        return list;
    }

    public List<Product> showCart(String userName) {
        User currentUser = UserMap.get(userName);
        return currentUser.showMyCart();
    }
}
