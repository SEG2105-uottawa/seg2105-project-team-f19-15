package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductTest {
    private Product ProductTest = new Product("234","amoxilin",24.5);

    @Test
    public void isInitialized(){
        assertNotNull(ProductTest);
    }

    @Test
    public void correctProductName() {
        assertEquals("pills", ProductTest.getProductName());
    }
    @Test
    public void correctProductID(){
        assertEquals("234",ProductTest.getId());
    }
    @Test
    public void correctPrice(){
       assertEquals (24.2,ProductTest.getPrice());

    }
    @Test
    public void correctsetProductName() {
        ProductTest.setProductName("pills");
        assertEquals("pills", ProductTest.getProductName());
    }

    @Test
    public void correctsetPrice(){
        ProductTest.setPrice(26.2);
       assertEquals(26.2,ProductTest.getPrice());
    }




}
