package com.example.toby.chapter_01.c;

import org.springframework.stereotype.Component;

@Component
public class Ca {
    public Ca() {
        print();
    }

    public void print() {
        System.out.println("Ca");
    }
}
