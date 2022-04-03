package com.example.toby.chapter_01.beans;

import org.springframework.stereotype.Component;

@Component
public class Zoo {

    public Zoo() {
        print();
    }

    public void print() {
        System.out.println("Zoo");
    }
}
