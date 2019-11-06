package com.example.project;
import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String password;
    private String email;
    private String identity;

    public Account(String name, String password, String email, String identity){
        this.name =name;
        this.password = password;
        this.email = email;
        this.identity= identity;
    }
    public Account(){
        this.name=null;
        this.password=null;
        this.email=null;
        this.identity=null;
    }
    public String getidentity(){
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
    public void setIdentity(String identity){
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
        return identity+" "+name+" " + email+" "+identity+" ";
    }




}