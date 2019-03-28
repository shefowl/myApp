package com.example.myApp;

import com.example.myApp.ShopClasses.Participants.User;
import com.example.myApp.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class GreetingController
{
    private final ServiceImpl ServiceImpl;

    @Autowired
    public GreetingController(ServiceImpl ServiceImpl) {
        this.ServiceImpl = ServiceImpl;
    }


    @RequestMapping(value = "/users", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<User> getUser()
    {
        List<User> list = ServiceImpl.getAllUsers();
        return list;
    }

    @RequestMapping(value = "/user/{userName}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("userName") String userName)
    {

         User user = ServiceImpl.readUser(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User addUser(@RequestBody User user)
    {
        System.out.println("(Service Side) Creating user: " + user.getUserName());
        return ServiceImpl.creatUser(user);
    }

    @RequestMapping(value = "/user", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User updateUser(@RequestBody User user)
    {
        System.out.println("(Service Side) Editing user: " + user.getUserName());
        return ServiceImpl.updateUser(user);
    }

    @RequestMapping(value = "/user/{userName}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteUser(@PathVariable("userName") String userName) {

        System.out.println("(Service Side) Deleting user: " + userName);

        ServiceImpl.deleteUser(userName);
    }
//    @PostMapping("/user")
//    public User user(@RequestParam(name="name", required=false, defaultValue="World") String value, Model model)
//    {
//        User newUser = new User("nagibator2012","1234");
//        //list.add(newUser);
//        return newUser;//new User("adf","123");
//    }
//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
//    {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
}
