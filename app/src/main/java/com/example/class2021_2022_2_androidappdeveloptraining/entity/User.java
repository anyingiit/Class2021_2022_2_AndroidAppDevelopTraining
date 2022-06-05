package com.example.class2021_2022_2_androidappdeveloptraining.entity;

public class User {
    private final int id;
    private String seatName;
    private final String username;

    private String password;
    private String phone;
    private String address;

    public User(int userId, String username, String password, String phone, String address) {
        this.id = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSeatName() {
        return seatName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}
