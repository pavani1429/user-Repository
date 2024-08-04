package com.demo.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.model.UserModel;
import com.demo.user.serviceImpl.UserServiceImpl;

@RestController

@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserService userService;
	
	
//	UserServiceImpl userService = new UserServiceImpl();
	@Autowired
	UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
    	UserModel createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserModel> updateUser(@PathVariable String email, @RequestBody UserModel userDetails) {
        Optional<UserModel> updatedUser = userService.updateUser(email, userDetails);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        try {
            if(userService.deleteUser(email)) {
            	return ResponseEntity.ok("SuccessFully Deleted :"+email);
            }
            else {
            	return ResponseEntity.ok("Record not found : " + email);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
