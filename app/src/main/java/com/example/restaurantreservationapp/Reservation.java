package com.example.restaurantreservationapp;

public class Reservation {
    private int id;
    private String date;
    private String hour;
    private  int id_user;

    public Reservation(){
        this.id = 0;
        this.date = "";
        this.hour = "";
    }
    public Reservation(int id_user, String date,String hour){
        this.id = 0;
        this.id_user = id_user;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setUserID(int id_user) {
        this.id_user = id_user;
    }

    public int getUserID() {
        return id_user;
    }
}
