package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void matchesIfTrue() {
        Product number1 = new Smartphone(1,"1C0",1,"Samsung");
        boolean actual = number1.matches("1C0");
        boolean expected = true;
        assertTrue(actual);
    }
    @Test
    void matchesIfFalse() {
        Product number1 = new Smartphone(1,"2C0",2,"Samsung");
        boolean actual = number1.matches("1C0");
        boolean expected = false;
        assertFalse(actual);
    }
}