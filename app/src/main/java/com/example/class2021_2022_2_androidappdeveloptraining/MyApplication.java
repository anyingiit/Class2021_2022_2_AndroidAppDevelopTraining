package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Application;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dishes;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCard;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.User;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Users;

public class MyApplication extends Application {
    private User loginUser;
    private Users users;
    private ShoppingCard shoppingCart;
    private Dishes dishes;

    @Override
    public void onCreate() {
        super.onCreate();

        initUsers();
        initDishs();
    }

    private void initDishs() {
        dishes = new Dishes();
        dishes.addDish("宫保鸡丁", 0, 15.5f);
        dishes.addDish("鱼香肉丝", 0, 13.8f);
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
        return dishes;
    }

    public void setUserLogout() {
        loginUser = null;
    }

    public boolean IsUserLogin() {
        return loginUser != null;
    }

    public void userLogin(User user) {
        this.loginUser = user;
        shoppingCart = new ShoppingCard(loginUser.getUsername());
    }


    public User getLoginUser() {
        return loginUser;
    }

    public Users getUsers() {
        return users;
    }

    public ShoppingCard getShoppingCart() {
        return shoppingCart;
    }
}
