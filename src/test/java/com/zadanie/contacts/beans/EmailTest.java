package com.zadanie.contacts.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {

    @Test
    public void isValidEmailAddress() {
        Email instance = new Email();
        boolean testunit = instance.isValidEmailAddress("jkowalski@gmail.com");
        boolean result = true;
        assertEquals(testunit, result);

        testunit = instance.isValidEmailAddress("aaa");
        result = false;
        assertEquals(testunit, result);

        testunit = instance.isValidEmailAddress("aaa.aa.aa");
        result = false;
        assertEquals(testunit, result);

        testunit = instance.isValidEmailAddress("aaaa@aaaaaaaaaaaaaaaa.aa");
        result = true;
        assertEquals(testunit, result);
    }

}