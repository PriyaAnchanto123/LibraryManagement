package org.management.lms.controller;

import org.management.lms.model.User;
import org.management.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    List<User> users=new ArrayList<>();

    @Autowired
    UserService userService;


    @PostMapping("/users")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "user created successfully with id: "+user.getId();
    }

    @GetMapping("/users")
    public List<User> getAll() {
    return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
    userService.delete(id);
    return "user with id: "+id+" is deleted";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user) {
         userService.update(id,user);
         return "user updated with new details";
    }

}
