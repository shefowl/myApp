package com.example.myApp;

import com.example.myApp.ShopClasses.Participants.Admin;
import com.example.myApp.ShopClasses.Participants.Enum.ParticipantRoleEnum;
import com.example.myApp.ShopClasses.Participants.ShopParticipant;
import com.example.myApp.ShopClasses.Participants.User;
import com.example.myApp.ShopClasses.Participants.Vendor;
import com.example.myApp.exeptions.EntityNotFoundException;
import com.example.myApp.exeptions.SuchUserAlreadyExistException;
import com.example.myApp.repository.UserCrudRepository;
import com.example.myApp.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

//import com.example.myApp.repository.UserCrudRepository;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private ServiceImpl ServiceImpl;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping(path="/all") // get all
    public @ResponseBody Iterable<ShopParticipant> getAllUsers(){
        return ServiceImpl.getAllUsers();
    }
       @RequestMapping(value = "/users/admin", // create admin
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addNewParticipant (@RequestBody @Valid Admin newAdmin){
           ServiceImpl.creatUser(newAdmin);
        return newAdmin;
    }
    @RequestMapping(value = "/registration", // create user
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewParticipant (@RequestBody @Valid User newUser){
        User user = userCrudRepository.findByUserName(newUser.getUserName());

        if(user != null){
            throw new  SuchUserAlreadyExistException();
        }
        newUser.setRole(Collections.singleton(ParticipantRoleEnum.USER));
        newUser.setActive(true);
        ServiceImpl.creatUser(newUser);
        return newUser;
    }

    @RequestMapping(value = "/users/vendor", // create vendor
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor addNewParticipant (@RequestBody @Valid Vendor newVendor){
        ServiceImpl.creatUser(newVendor);
        return newVendor;
    }

        @RequestMapping(value = "/users/{id}", // read
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<ShopParticipant> getUser(@PathVariable("id") Integer id) {
        return ServiceImpl.readUser(id);
    }

        @RequestMapping(value = "/users/{username}", // update
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User updateUser(@RequestBody User sp,/* @PathVariable("id") Integer id)*/
                                      @PathVariable("username") String username) {
            User spOld = userCrudRepository.findByUserName(sp.getUserName());
        if(spOld == null) {
            throw new EntityNotFoundException();
        }
        int id = spOld.getAccountId();
        sp.setAccountId(id);
        return ServiceImpl.updateUser(sp);
    }

        @RequestMapping(value = "/users/{id}", // delete
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser( @PathVariable("id") Integer id) {
        ServiceImpl.deleteUser(id);
    }
}
