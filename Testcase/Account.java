package com.example.myapplication;

public class Account {
    private String name;
    private String password;
    private String email;
    private Identity identity;

    public Account(String name, String password,String email,Identity identity){
        this.name =name;
        this.password = password;
        this.email = email;
        this.identity= identity;
    }
    public Account(){}


    public Identity getidentity(){
        return identity;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }
    public void setIdentity(Identity identity){
        this.identity = identity;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return name+" " + email+" "+identity+" ";
    }




}

