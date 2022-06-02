package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    private MyUser_stu user;
    private ShoppingCart_stu shoppingCart_stu;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
