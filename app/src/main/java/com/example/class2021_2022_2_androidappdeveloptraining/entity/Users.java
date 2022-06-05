package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

public class Users {
    private final ArrayList<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username, String password, String phone, String address) {
        users.add(new User(users.size(), username, password, phone, address));
    }

    public User findUserByUsername(String username) {
        for (User user :
                users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User findUserByPhone(String phone) {
        for (User user :
                users) {
            if (user.getPhone().equals(phone)) {
                return user;
            }
        }

        return null;
    }

    private boolean hasUserListIndex(int index) {
        return index >= 0 && index <= users.size() - 1;
    }

    private boolean hasUserId(int id) {
        return hasUserListIndex(id);
    }

    public User getUserById(int userId) {
        if (!hasUserId(userId)) {
            return null;
        }

        return users.get(userId);
    }
}
