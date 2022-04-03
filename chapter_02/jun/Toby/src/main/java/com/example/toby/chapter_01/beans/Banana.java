package com.example.toby.chapter_01.beans;

import org.springframework.stereotype.Component;

@Component
public class Banana {

    public Banana() {
        print();
    }

    public void print() {
        System.out.println("Banana");
    }
}
