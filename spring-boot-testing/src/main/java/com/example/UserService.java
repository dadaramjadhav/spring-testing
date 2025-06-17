package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Users findUserById(int id) {
        return userRepo.findById(id).get();
    }

    public Users saveUser(Users user) {
        return userRepo.save(user);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public Users updateUser(Users user) {
        return userRepo.save(user);
    }
}
