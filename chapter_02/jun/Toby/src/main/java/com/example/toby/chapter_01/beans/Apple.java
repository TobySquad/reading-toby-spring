package com.example.toby.chapter_01.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Apple {

    @Autowired
    private Zoo zoo;

    public Apple(Zoo zoo) {
        this.zoo = zoo;
        print();
    }

    public void print() {
        System.out.println("Apple");
    }
}
