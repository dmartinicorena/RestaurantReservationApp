package com.example.restaurantreservationapp;

public class User {
    private int id;
    private String name;
    private String login;
    private String pass;

    public User(){
        this.id = 0;
        this.name = "";
        this.login = "";
        this.pass = "";
    }
    public User(String name,String login, String pass){
        this.id = 0;
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

