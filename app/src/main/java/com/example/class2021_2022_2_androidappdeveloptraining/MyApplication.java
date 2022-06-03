package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dishes;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCard;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.User;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Users;

public class MyApplication extends Application {
    private User loginUser;
    private Users users;
    private ShoppingCard shoppingCart_stu;
    private Dishes dishes_;

    @Override
    public void onCreate() {
        super.onCreate();

        initUsers();
        initDishs();
    }

    private void initDishs() {
        dishes_ = new Dishes();
        dishes_.addDish(new Dish("宫保鸡丁", 0, 15.5f));
    }

    private void initUsers() {
        users = new Users();

        users.addUser("user1", "123", "15888888881", "花村");
        users.addUser("user2", "123", "15888888881", "花村");
        users.addUser("user3", "123", "15888888881", "花村");
        users.addUser("user4", "123", "15888888881", "花村");
        users.addUser("user5", "123", "15888888881", "花村");
    }

    public Dishes getDishes_stu() {
        return dishes_;
    }

    public void setUserLogout() {
        loginUser = null;
    }

    public boolean IsUserLogin() {
        return loginUser != null;
    }

    public void userLogin(User user) {
        this.loginUser = user;
    }


    public User getLoginUser() {
        return loginUser;
    }

    public Users getUsers() {
        return users;
    }
}
