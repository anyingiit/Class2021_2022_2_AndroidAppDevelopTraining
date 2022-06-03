package com.example.class2021_2022_2_androidappdeveloptraining;

import java.util.ArrayList;

public class ShoppingCart_stu {
    private String mUserName_stu;
    private ArrayList<OrderItem_stu> mOrderItems_stu;

    ShoppingCart_stu(String username) {
        this.mUserName_stu = username;
    }

    ShoppingCart_stu(String username, ArrayList<OrderItem_stu> orderItems) {
        this.mUserName_stu = username;
        this.mOrderItems_stu = orderItems;
    }

    public int getOrderItemQuantityWyc() {
        return mOrderItems_stu.size();
    }

    private boolean hasIndex(int index) {
        return index >= 0 && index <= mOrderItems_stu.size() - 1;
    }

    public OrderItem_stu getOrderByIndex(int index) {
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


    public int addOrderItem(Dish_stu dish, int quantity) {
        int orderIndex = getOrderIndexByDishName(dish.getmName_stu());
        if (orderIndex == -1) {
            mOrderItems_stu.add(new OrderItem_stu(dish, quantity));
            return mOrderItems_stu.size() - 1;
        }

        OrderItem_stu orderItem = mOrderItems_stu.get(orderIndex);
        orderItem.setQuantity(orderItem.getQuantity_stu() + quantity);

        return orderIndex;
    }

    public float getTotalPrise() {
        int result = 0;
        for (OrderItem_stu item :
                mOrderItems_stu) {
            result += item.getQuantity_stu();
        }

        return result;
    }

//    public void EditOderItemQuantity()
}
