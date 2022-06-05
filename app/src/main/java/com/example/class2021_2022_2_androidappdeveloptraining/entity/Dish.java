package com.example.class2021_2022_2_androidappdeveloptraining.entity;

// Dish_stu 菜品
public class Dish {
    private final int id;
    private final String name;
    private final int image;
    private final float price;

    public Dish(int id, String name, int image, float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
