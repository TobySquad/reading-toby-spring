package com.example.toby.chapter_01.beans;

import org.springframework.stereotype.Component;

@Component
public class Coconut {

    public Coconut() {
        print();
    }

    void print(){
        System.out.println("Coconut");
    }
}
