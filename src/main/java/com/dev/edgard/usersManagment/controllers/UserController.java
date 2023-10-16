package com.dev.edgard.usersManagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.edgard.usersManagment.models.User;
import com.dev.edgard.usersManagment.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;


    @GetMapping("users")
    public List<User> getAllUsers(){
        List<User> allUsers = userService.findAllUsers();
        return allUsers;
    }


    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Long id){
        User user = userService.findUser(id);
        return user;
    }


    @PostMapping("user/new")
    public ResponseEntity<String> createUser(@RequestBody User user){
        ResponseEntity<String> newUserResponseStatus = userService.createUser(user);
        return newUserResponseStatus;
    }


    @PutMapping("user/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        ResponseEntity<String> updatedUserResponseStatus = userService.updateUser(id, user);
        return updatedUserResponseStatus;
    }


    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        ResponseEntity<String> deletedUserResponseStatus = userService.deleteUser(id);
        return deletedUserResponseStatus;
    }
   
}
