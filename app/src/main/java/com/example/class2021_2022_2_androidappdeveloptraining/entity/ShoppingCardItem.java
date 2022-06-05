package com.example.class2021_2022_2_androidappdeveloptraining.entity;

public class ShoppingCardItem {
    private Dish dish_stu;
    private int mQuantity_stu;

    public ShoppingCardItem(Dish dish, int quantity) {
        this.dish_stu = dish;
        this.mQuantity_stu = quantity;
    }

    public Dish getDish_stu() {
        return dish_stu;
    }

    public int getQuantity_stu() {
        return mQuantity_stu;
    }

    public float getItemTotalPriceWyc() {
        return dish_stu.getmPrice_stu() * mQuantity_stu;
    }

    public void setQuantity(int newQuantity) {
        mQuantity_stu = newQuantity;
    }
}
