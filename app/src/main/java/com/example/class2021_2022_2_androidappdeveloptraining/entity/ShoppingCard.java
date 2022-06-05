package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

public class ShoppingCard {
    private String mUserName_stu;
    private ArrayList<ShoppingCardItem> mShoppingCardItems_stu;

    public ShoppingCard(String username) {
        this.mUserName_stu = username;
        mShoppingCardItems_stu = new ArrayList<>();
    }

    public ShoppingCard(String username, ArrayList<ShoppingCardItem> shoppingCardItems) {
        this.mUserName_stu = username;
        this.mShoppingCardItems_stu = shoppingCardItems;
    }

    public int getOrderItemQuantityWyc() {
        return mShoppingCardItems_stu.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= mShoppingCardItems_stu.size() - 1;
    }

    public ShoppingCardItem getOrderByIndex(int index) {
        if (!hasIndex(index)) {
            return null;
        }

        return mShoppingCardItems_stu.get(index);
    }

    public boolean deleteOrderItemByIndex(int index) {
        if (!hasIndex(index)) {
            return false;
        }
        mShoppingCardItems_stu.remove(index);

        return true;
    }

    /**
     * @return not has dish then return -1
     */
    private int getOrderIndexByDishName(String dishName) {
        for (int i = 0; i < mShoppingCardItems_stu.size(); i++) {
            if (mShoppingCardItems_stu.get(i).getDish_stu().getmName_stu().equals(dishName)) {
                return i;
            }
        }
        return -1;
    }


    public int addOrderItem(Dish dish, int quantity) {
        int orderIndex = getOrderIndexByDishName(dish.getmName_stu());
        if (orderIndex == -1) {
            mShoppingCardItems_stu.add(new ShoppingCardItem(dish, quantity));
            return mShoppingCardItems_stu.size() - 1;
        }

        ShoppingCardItem shoppingCardItem = mShoppingCardItems_stu.get(orderIndex);
        shoppingCardItem.setQuantity(shoppingCardItem.getQuantity_stu() + quantity);

        return orderIndex;
    }

    public float getTotalPrise() {
        int result = 0;
        for (ShoppingCardItem item :
                mShoppingCardItems_stu) {
            result += item.getItemTotalPriceWyc();
        }

        return result;
    }

    public int size() {
        return mShoppingCardItems_stu.size();
    }

//    public void EditOderItemQuantity()
}
