package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void matchesIfTrue() {
        Product number1 = new Book(1,"Gordost i predugdenia",1,"Ostin");
        boolean actual = number1.matches("Gordost i predugdenia");
        boolean expected = true;
        assertTrue(actual);
    }
    @Test
    void matchesIfFalse() {
        Product number1 = new Book(1,"Dgein Eer",2,"Ostin");
        boolean actual = number1.matches("Gordost i predugdenia");
        boolean expected = false;
        assertFalse(actual);
    }
}