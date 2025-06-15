package com.example;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findById(int id) {
        return new User(id, "RealUser");
    }

    public void save(User user) {
        System.out.println("Saving: " + user.getName());
    }

    public void delete(int id) {
        System.out.println("Deleting user with id: " + id);
    }

    //testing void method
    public void updateUser(int id){
        System.out.println("user updated with id "+ id);
    }

    public void mimicDelay(int a){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is to mimic a delay .. value is : "+a);
    }
}