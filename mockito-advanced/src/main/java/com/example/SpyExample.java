package com.example;

import org.springframework.stereotype.Service;

@Service
public class SpyExample {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
}
