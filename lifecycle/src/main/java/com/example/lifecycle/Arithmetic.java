package com.example.lifecycle;

public class Arithmetic {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a * b;
    }

    public int div(int a, int b) throws ArithmeticException{
        if(b==0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
    public boolean isEven(int num){
        return num%2==0;
    }
}
