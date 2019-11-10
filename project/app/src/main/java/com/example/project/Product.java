package com.example.project;


public class Product {
    private String _id;
    private String _productname;
    private double _price;
    private String _person;

    public Product() {
    }
    public Product(String id, String productname, double price, String person) {
        _id = id;
        _productname = productname;
        _price = price;
        _person=person;
    }
    public Product(String productname, double price, String person) {
        _productname = productname;
        _price = price;
        _person= person;
    }

    public void setId(String id) {
        _id = id;
    }
    public String getId() {
        return _id;
    }
    public void setProductName(String productname) {
        _productname = productname;
    }
    public String getProductName() {
        return _productname;
    }
    public void setPrice(double price) {
        _price = price;
    }
    public double getPrice() {
        return _price;
    }
    public void set_person(String person){_person=person;}
    public String getPerson() {
        return  _person;
    }

}
