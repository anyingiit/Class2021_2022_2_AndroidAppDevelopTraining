package com.example.class2021_2022_2_androidappdeveloptraining.entity;

public class OrderItem_stu {
    private Dish_stu dish_stu;
    private int mQuantity_stu;

    OrderItem_stu(Dish_stu dish, int quantity) {
        this.dish_stu = dish;
        this.mQuantity_stu = quantity;
    }

    public Dish_stu getDish_stu() {
        return dish_stu;
    }

    public int getQuantity_stu() {
        return mQuantity_stu;
    }

    public float GetItemTotalPrice_stu() {
        return dish_stu.getmPrice_stu() * mQuantity_stu;
    }

    public void setQuantity(int newQuantity) {
        mQuantity_stu = newQuantity;
    }
}
