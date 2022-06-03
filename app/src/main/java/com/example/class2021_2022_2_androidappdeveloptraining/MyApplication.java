package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dishes;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCard;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.User;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<User> userList;
    private User user;
    private ShoppingCard shoppingCart_stu;
    private Dishes dishes_;

    @Override
    public void onCreate() {
        super.onCreate();

        userList = new ArrayList<>();

        initFakeUser();
        initDishs();
    }

    private void initDishs() {
        dishes_ = new Dishes();
        dishes_.addDish(new Dish("宫保鸡丁", 0, 15.5f));
    }

    private void initFakeUser() {
        addUser("user1", "123", "15888888881", "花村");
        addUser("user2", "123", "15888888881", "花村");
        addUser("user3", "123", "15888888881", "花村");
        addUser("user4", "123", "15888888881", "花村");
        addUser("user5", "123", "15888888881", "花村");
    }

    public Dishes getDishes_stu() {
        return dishes_;
    }

    public void setUserLogout() {
        user = null;
    }

    public boolean IsUserLogin() {
        return user != null;
    }

    public void userLogin(User user) {
        this.user = user;
    }

    public void addUser(String username, String password, String phone, String address) {
        int newID = userList.size() == 0 ? 0 : userList.get(userList.size() - 1).getmUserId_stu() + 1;
        userList.add(new User(newID, username, password, phone, address));
    }

    public User findUserByUsername(String username) {
        for (User user :
                userList) {
            if (user.getmUsername_stu().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User findUserByPhone(String phone) {
        for (User user :
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

    public User getUserById(int userId) {
        if (!hasUserId(userId)) {
            return null;
        }

        return userList.get(userId);
    }

    public User getUser() {
        return user;
    }
}
