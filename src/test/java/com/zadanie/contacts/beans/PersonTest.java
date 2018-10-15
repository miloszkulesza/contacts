package com.zadanie.contacts.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void isValidPesel() {
        Person instance = new Person();
        boolean test = instance.isVaildPesel("95876710299");
        boolean result = true;
        assertEquals(test, result);

        test = instance.isVaildPesel("a9512290398");
        result = false;
        assertEquals(test, result);
    }

}