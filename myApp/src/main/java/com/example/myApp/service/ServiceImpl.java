package com.example.myApp.service;

import com.example.myApp.ShopClasses.Participants.Admin;
import com.example.myApp.ShopClasses.Participants.ShopParticipant;
import com.example.myApp.exeptions.EntityNotFoundException;
import com.example.myApp.repository.MyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//import com.example.myApp.ShopClasses.Participants.User;

@Service
public class ServiceImpl implements AbstractService {
    private final MyCrudRepository repository;

    @Autowired
    public ServiceImpl(MyCrudRepository repository){
        this.repository = repository;
    }

    public ShopParticipant creatUser(ShopParticipant account) {
//        if(UserMap.containsKey(account.getUserName())) {
//            throw new SuchUserAlreadyExistException();
//        }
        repository.save(account);
        return account;
    }

    public Optional<ShopParticipant> readUser(Integer id) throws EntityNotFoundException {
        Optional<ShopParticipant> n;
        n = repository.findById(id);
        if(!n.isPresent()){
            throw new EntityNotFoundException();
        }
       return repository.findById(id);
    }

    public Admin updateUser(Admin account) {
//        if(!UserMap.containsKey(account.getUserName())) {
//            throw new EntityNotFoundException();
//        }
        repository.save(account);
        return account;
    }

    public void deleteUser(Integer id) throws EntityNotFoundException{
        repository.deleteById(id);
    }
//
    public Iterable<ShopParticipant> getAllUsers(){
        return repository.findAll();
    }
//
//    public List<Product> showCart(String userName) {
//        ShopParticipant currentUser = UserMap.get(userName);
//        return currentUser.showMyCart();
//    }
}
