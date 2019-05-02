package com.example.myApp;

import com.example.myApp.ShopClasses.Participants.User;
import com.example.myApp.exeptions.EntityNotFoundException;
import com.example.myApp.exeptions.UserListIsEmptyException;
import com.example.myApp.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class GreetingController {

    private final ServiceImpl ServiceImpl;

    @Autowired
    public GreetingController(ServiceImpl ServiceImpl) {
        this.ServiceImpl = ServiceImpl;
    }


    @RequestMapping(value = "/users/all", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody

    public List<User> getUser() {
        List<User> list = ServiceImpl.getAllUsers();
        return list;
    }

    @RequestMapping(value = "/users/{userName}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("userName") String userName) {
//        try {
                 User user = ServiceImpl.readUser(userName);
                 if(user == null){
                     throw new EntityNotFoundException();
                 }
                 return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody @Valid User user) {

        System.out.println("(Service Side) Creating user: " + user.getUserName());
        return ServiceImpl.creatUser(user);
    }

    @RequestMapping(value = "/users", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        System.out.println("(Service Side) Editing user: " + user.getUserName());
        return ServiceImpl.updateUser(user);
    }

    @RequestMapping(value = "/users/{userName}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userName") String userName) {

        System.out.println("(Service Side) Deleting user: " + userName);

        ServiceImpl.deleteUser(userName);
    }

    @RequestMapping(value = "/users/{userName}/cart", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void showUserCart(@PathVariable("userName") String userName) {
        ServiceImpl.showCart(userName);
    }
}
