package com.example.toby.chapter_01.abeans;

import org.springframework.stereotype.Component;

@Component
public class Aa {

    public Aa() {
        print();
    }

    public void print() {
        System.out.println("Aa");
    }
}
