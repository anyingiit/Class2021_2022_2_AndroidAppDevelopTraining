package com.example.class2021_2022_2_androidappdeveloptraining.entity;

public class ShoppingCardItem {
    private final Dish dish;
    private int quantity;

    public ShoppingCardItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getItemTotalPrice() {
        return dish.getPrice() * quantity;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }
}
