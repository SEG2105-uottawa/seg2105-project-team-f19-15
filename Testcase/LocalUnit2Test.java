package com.example.myapplication;

import org.junit.Test;


import static org.junit.Assert.*;

public class LocalUnit2Test {
    private Account AccountTest = new Account("ShuaiWudi","5TQ5TS","1229087652@qq.com", Identity.patient);

    @Test
    public void isInitialized(){
        assertNotNull(AccountTest);
    }

    @Test
    public void correctAccountName() {
        assertEquals("ShuaiWudi", AccountTest.getName());
    }
    @Test
    public void correctAccountnMame(){
        assertEquals(Identity.patient,AccountTest.getidentity());
    }
    @Test
    public void correctAccountEmail(){
        assertEquals("1229087652@qq.com",AccountTest.getEmail());

    }
    @Test
    public void correctAccountPassword(){
        assertEquals("5TQ5TS",AccountTest.getPassword());

    }

}
