package com.zadanie.contacts.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    @Test
    public void isValidPhoneNumber() {
        Phone instance = new Phone();
        String number = "555222242";
        boolean result = instance.isValidPhoneNumber(number);
        boolean expected = true;
        assertEquals(result, expected);

        number = "1234123";
        result = instance.isValidPhoneNumber(number);
        expected = false;
        assertEquals(result, expected);

        number = "abcdswer";
        result = instance.isValidPhoneNumber(number);
        expected = false;
        assertEquals(result, expected);
    }
}