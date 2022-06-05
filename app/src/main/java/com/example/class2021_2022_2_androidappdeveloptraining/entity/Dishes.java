package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

/**
 * Class {@code Dishes_stu} use with menu
 */
public class Dishes {
    private final ArrayList<Dish> dishes;

    public Dishes() {
        this.dishes = new ArrayList<>();
    }

    public Dish findDishByDishName(String dishName) {
        for (Dish dish : dishes) {
            if (dish.getName().equals(dishName)) {
                return dish;
            }
        }
        return null;
    }

    public Dish findDishByDishId(int dishId) {
        for (Dish dish : dishes) {
            if (dish.getId() == dishId) {
                return dish;
            }
        }
        return null;
    }

    public int getSize() {
        return dishes.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= getSize() - 1;
    }

    public Dish getDish(int index) {
        if (!hasIndex(index)) {
            return null;
        }
        return dishes.get(index);
    }

    public void addDish(String name, int image, float price) {
        dishes.add(new Dish(dishes.size(), name, image, price));
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }
}
