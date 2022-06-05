package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

/**
 * Class {@code Dishes_stu} use with menu
 */
public class Dishes {
    private final ArrayList<Dish> mDishes_stu;

    public Dishes() {
        this.mDishes_stu = new ArrayList<>();
    }

    public Dish getDishByName_stu(String name) {
        for (Dish dish : mDishes_stu) {
            if (dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }

    public int getSize() {
        return mDishes_stu.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= getSize() - 1;
    }

    public Dish getDishByIndex(int index) {
        if (!hasIndex(index)) {
            return null;
        }
        return mDishes_stu.get(index);
    }

    public void addDish(String name, int image, float price) {
        mDishes_stu.add(new Dish(mDishes_stu.size(), name, image, price));
    }

    public ArrayList<Dish> getRow() {
        return mDishes_stu;
    }
}
