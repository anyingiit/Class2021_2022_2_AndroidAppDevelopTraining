package com.example.class2021_2022_2_androidappdeveloptraining.entity;

import java.util.ArrayList;

public class ShoppingCard {
    private String mUserName_stu;
    private ArrayList<OrderItem> mOrderItems_stu;

    ShoppingCard(String username) {
        this.mUserName_stu = username;
    }

    ShoppingCard(String username, ArrayList<OrderItem> orderItems) {
        this.mUserName_stu = username;
        this.mOrderItems_stu = orderItems;
    }

    public int getOrderItemQuantityWyc() {
        return mOrderItems_stu.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= mOrderItems_stu.size() - 1;
    }

    public OrderItem getOrderByIndex(int index) {
        if (!hasIndex(index)) {
            return null;
        }

        return mOrderItems_stu.get(index);
    }

    public boolean deleteOrderItemByIndex(int index) {
        if (!hasIndex(index)) {
            return false;
        }
        mOrderItems_stu.remove(index);

        return true;
    }

    /**
     * @return not has dish then return -1
     */
    private int getOrderIndexByDishName(String dishName) {
        for (int i = 0; i < mOrderItems_stu.size(); i++) {
            if (mOrderItems_stu.get(i).getDish_stu().getmName_stu().equals(dishName)) {
                return i;
            }
        }
        return -1;
    }


    public int addOrderItem(Dish dish, int quantity) {
        int orderIndex = getOrderIndexByDishName(dish.getmName_stu());
        if (orderIndex == -1) {
            mOrderItems_stu.add(new OrderItem(dish, quantity));
            return mOrderItems_stu.size() - 1;
        }

        OrderItem orderItem = mOrderItems_stu.get(orderIndex);
        orderItem.setQuantity(orderItem.getQuantity_stu() + quantity);

        return orderIndex;
    }

    public float getTotalPrise() {
        int result = 0;
        for (OrderItem item :
                mOrderItems_stu) {
            result += item.getQuantity_stu();
        }

        return result;
    }

//    public void EditOderItemQuantity()
}
