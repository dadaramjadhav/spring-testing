package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users>  getUserById(@PathVariable int id) {
        return new ResponseEntity<>( userService.findUserById(id), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @PutMapping("/users")
    public Users updateUser(Users user) {
        return userService.updateUser(user);
    } 

}
