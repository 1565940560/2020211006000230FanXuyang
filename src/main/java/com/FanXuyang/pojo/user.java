package com.FanXuyang.pojo;

public class user {
    private  String ID;
    private  String name;
    private  String password;
    private  String Email;
    private  String Gender;
    private  String Birthdate;

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }
}
