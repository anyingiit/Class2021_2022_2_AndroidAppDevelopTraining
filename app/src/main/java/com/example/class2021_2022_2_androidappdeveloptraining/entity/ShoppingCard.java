package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

public class ShoppingCard {
    private final String username;
    private final ArrayList<ShoppingCardItem> shoppingCardItems;

    public ShoppingCard(String username) {
        this.username = username;
        shoppingCardItems = new ArrayList<>();
    }

    public int getQuantity() {
        return shoppingCardItems.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= shoppingCardItems.size() - 1;
    }

    public ShoppingCardItem getItem(int index) {
        if (!hasIndex(index)) {
            return null;
        }

        return shoppingCardItems.get(index);
    }

    public boolean deleteItem(int index) {
        if (!hasIndex(index)) {
            return false;
        }
        shoppingCardItems.remove(index);
        return true;
    }

    /**
     * @return if not has dish then return -1
     */
    private int findItemByDishName(String dishName) {
        for (int i = 0; i < shoppingCardItems.size(); i++) {
            if (shoppingCardItems.get(i).getDish().getName().equals(dishName)) {
                return i;
            }
        }
        return -1;
    }


    public int addItem(Dish dish, int quantity) {
        int orderIndex = findItemByDishName(dish.getName());
        if (orderIndex == -1) {
            shoppingCardItems.add(new ShoppingCardItem(dish, quantity));
            return shoppingCardItems.size() - 1;
        }

        ShoppingCardItem shoppingCardItem = shoppingCardItems.get(orderIndex);
        shoppingCardItem.setQuantity(shoppingCardItem.getQuantity() + quantity);

        return orderIndex;
    }

    public float getTotalPrise() {
        int result = 0;
        for (ShoppingCardItem item :
                shoppingCardItems) {
            result += item.getItemTotalPrice();
        }

        return result;
    }

    public int size() {
        return shoppingCardItems.size();
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<ShoppingCardItem> getShoppingCardItems() {
        return shoppingCardItems;
    }
}
