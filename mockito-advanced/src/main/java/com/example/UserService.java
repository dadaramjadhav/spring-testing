package com.example;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserName(int id) {
        return repository.findById(id).getName();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteUser(int id) {
        repository.delete(id);
    }

    public void modifyUser(int id){
        repository.updateUser(id);
    }

    public void callMimicDelay(){
        repository.mimicDelay(10);
    }
}
