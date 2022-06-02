package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<MyUser_stu> userList;
    private MyUser_stu user;
    private ShoppingCart_stu shoppingCart_stu;

    @Override
    public void onCreate() {
        super.onCreate();

        userList = new ArrayList<>();

        initFakeUser();
    }

    private void initFakeUser() {
        userList.add(new MyUser_stu(0, "user1", "123", "15888888881", "花村"));
        userList.add(new MyUser_stu(1, "user2", "123", "15888888881", "花村"));
        userList.add(new MyUser_stu(2, "user3", "123", "15888888881", "花村"));
        userList.add(new MyUser_stu(3, "user4", "123", "15888888881", "花村"));
        userList.add(new MyUser_stu(4, "user5", "123", "15888888881", "花村"));
        userList.add(new MyUser_stu(5, "user6", "123", "15888888881", "花村"));
    }

    public void setUserLogout() {
        user = null;
    }

    public boolean IsUserLogin() {
        return user != null;
    }

    public void userLogin(MyUser_stu user) {
        this.user = user;
    }

    public void addUser(String username, String password, String phone, String address) {
        int newID = userList.get(userList.size() - 1).mUserId_stu + 1;
        userList.add(new MyUser_stu(newID, username, password, phone, address));
    }

    public MyUser_stu findUserByUsername(String username) {
        for (MyUser_stu user :
                userList) {
            if (user.mSeatName_stu.equals(username)) {
                return user;
            }
        }

        return null;
    }

    public MyUser_stu findUserByPhone(String phone) {
        for (MyUser_stu user :
                userList) {
            if (user.mUserPhone_stu.equals(phone)) {
                return user;
            }
        }

        return null;
    }

}
