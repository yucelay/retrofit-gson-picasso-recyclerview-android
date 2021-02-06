package com.yucel.retrofitpicassoandroid.model;

public class User {

    int id;
    String name;
    String surname;
    String photo;

    public User(String name, String surname, String photo) {
        this.name = name;
        this.surname = surname;
        this.photo = photo;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
