package com.example.project;


public class Product {
    private String _id;
    private String _productName;
    private double _price;
    private String _person;

    public Product() {
    }
    public Product(String id, String productName, double price, String person) {
        _id = id;
        _productName = productName;
        _price = price;
        _person =person;
    }
    public Product(String productName, double price) {
        _productName = productName;
        _price = price;
    }

    public void setId(String id) {
        _id = id;
    }
    public String getId() {
        return _id;
    }
    public void setProductName(String productName) {
        _productName = productName;
    }
    public String getProductName() {
        return _productName;
    }
    public void setPrice(double price) {
        _price = price;
    }
    public double getPrice() {
        return _price;
    }
    public void setPerson(String person) {
        _person = person;
    }
    public String getPerson(){return _person;}

}
