package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish_stu;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dishes_stu;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.MyUser_stu;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCart_stu;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<MyUser_stu> userList;
    private MyUser_stu user;
    private ShoppingCart_stu shoppingCart_stu;
    private Dishes_stu dishes_stu;

    @Override
    public void onCreate() {
        super.onCreate();

        userList = new ArrayList<>();

        initFakeUser();
        initDishs();
    }

    private void initDishs() {
        dishes_stu = new Dishes_stu();
        dishes_stu.addDish(new Dish_stu("宫保鸡丁", 0, 15.5f));
    }

    private void initFakeUser() {
        addUser("user1", "123", "15888888881", "花村");
        addUser("user2", "123", "15888888881", "花村");
        addUser("user3", "123", "15888888881", "花村");
        addUser("user4", "123", "15888888881", "花村");
        addUser("user5", "123", "15888888881", "花村");
    }

    public Dishes_stu getDishes_stu() {
        return dishes_stu;
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
        int newID = userList.size() == 0 ? 0 : userList.get(userList.size() - 1).getmUserId_stu() + 1;
        userList.add(new MyUser_stu(newID, username, password, phone, address));
    }

    public MyUser_stu findUserByUsername(String username) {
        for (MyUser_stu user :
                userList) {
            if (user.getmUsername_stu().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public MyUser_stu findUserByPhone(String phone) {
        for (MyUser_stu user :
                userList) {
            if (user.getmUserPhone_stu().equals(phone)) {
                return user;
            }
        }

        return null;
    }

    private boolean hasUserListIndex(int index) {
        return index >= 0 && index <= userList.size() - 1;
    }

    private boolean hasUserId(int id) {
        return hasUserListIndex(id);
    }

    public MyUser_stu getUserById(int userId) {
        if (!hasUserId(userId)) {
            return null;
        }

        return userList.get(userId);
    }

    public MyUser_stu getUser() {
        return user;
    }
}
