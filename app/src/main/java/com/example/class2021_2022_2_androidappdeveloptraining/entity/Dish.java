package com.example.class2021_2022_2_androidappdeveloptraining.entity;

// Dish_stu 菜品
public class Dish {
    private int mId_stu = -1;
    private String mName_stu;
    private int mImage_stu;
    private float mPrice_stu;

    public Dish(int mId_stu, String mName_stu, int mImage_stu, float mPrice_stu) {
        this.mId_stu = mId_stu;
        this.mName_stu = mName_stu;
        this.mImage_stu = mImage_stu;
        this.mPrice_stu = mPrice_stu;
    }

    public Dish(String mName_stu, int mImage_stu, float mPrice_stu) {
        this.mName_stu = mName_stu;
        this.mImage_stu = mImage_stu;
        this.mPrice_stu = mPrice_stu;
    }

    public int getmId_stu() {
        return mId_stu;
    }

    public String getmName_stu() {
        return mName_stu;
    }

    public float getmPrice_stu() {
        return mPrice_stu;
    }

    public int getmImage_stu() {
        return mImage_stu;
    }
}
