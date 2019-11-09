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
     public void corrsctToString(){
        assertEquals("ShuaiWudi 1229087652@qq.com patient",AccountTest.toString());
    }
    public void correctSetIdentity(){
        assertEquals(Identity.employee,AccountTest.setIdentity(Identity.employee));
    }
    
    public void correctSetName(){
        assertEquals("Shuainiubi",AccountTest.setName("Shuainiubi"));
    }
    
    public void correctSetEmail(){
        assertEquals("199283746@qq.com",AccountTest.setEmail("199283746@qq.com"));
    }
    
    public void correctSetPassword(){
         assertEquals("11223369",AccountTest.setPassword("11223369"));
    }
   
        
    

}
