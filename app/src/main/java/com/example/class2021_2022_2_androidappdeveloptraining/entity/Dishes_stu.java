package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

/**
 * Class {@code Dishes_stu} use with menu
 */
public class Dishes_stu {
    private ArrayList<Dish_stu> mDishes_stu;

    public Dishes_stu() {
        this.mDishes_stu = new ArrayList<>();
    }

    public Dish_stu getDishByName_stu(String name) {
        for (Dish_stu dish : mDishes_stu) {
            if (dish.getmName_stu().equals(name)) {
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

    public Dish_stu getDishByIndex(int index) {
        if (!hasIndex(index)) {
            return null;
        }
        return mDishes_stu.get(index);
    }

    public void addDish(Dish_stu dish_stu) {
        mDishes_stu.add(new Dish_stu(mDishes_stu.size(), dish_stu.getmName_stu(), dish_stu.getmImage_stu(), dish_stu.getmPrice_stu()));
    }

    public ArrayList<Dish_stu> getRow() {
        return mDishes_stu;
    }
}
