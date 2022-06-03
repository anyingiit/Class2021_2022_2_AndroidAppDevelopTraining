package com.example.class2021_2022_2_androidappdeveloptraining.entity;

public class User {
    private int mUserId_stu;
    private String mSeatName_stu;
    private String mUsername_stu;

    private String mPassword_stu;
    private String mUserPhone_stu;
    private String mUserAddress_stu;

    public User(int userId, String username, String password, String phone, String address) {
        this.mUserId_stu = userId;
        this.mUsername_stu = username;
        this.mPassword_stu = password;
        this.mUserPhone_stu = phone;
        this.mUserAddress_stu = address;
    }

    public int getmUserId_stu() {
        return mUserId_stu;
    }

    public String getmUsername_stu() {
        return mUsername_stu;
    }

    public String getmSeatName_stu() {
        return mSeatName_stu;
    }

    public String getmPassword_stu() {
        return mPassword_stu;
    }

    public String getmUserPhone_stu() {
        return mUserPhone_stu;
    }

    public String getmUserAddress_stu() {
        return mUserAddress_stu;
    }

    public void setmUserPhone_stu(String mUserPhone_stu) {
        this.mUserPhone_stu = mUserPhone_stu;
    }

    public void setmUserAddress_stu(String mUserAddress_stu) {
        this.mUserAddress_stu = mUserAddress_stu;
    }
}
