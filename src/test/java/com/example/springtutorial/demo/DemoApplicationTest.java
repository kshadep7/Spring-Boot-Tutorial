package com.example.springtutorial.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoApplicationTest {

    @Test
    void helloTest() {
        DemoApplication demo = new DemoApplication();
        assertEquals("hello", demo.hello("hello"));
    }
}