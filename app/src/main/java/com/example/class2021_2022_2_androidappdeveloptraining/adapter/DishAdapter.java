package com.example.class2021_2022_2_androidappdeveloptraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;

import java.util.ArrayList;
import java.util.Locale;

public class DishAdapter extends BaseAdapter {

    Context context;
    ArrayList<Dish> dishes;

    View view;

    /**
     * @param context 上下文, 即adapter附着的对象
     * @param dishes  期望使用adapter处理的数据集合, 这里传入的是菜品的列表
     */
    public DishAdapter(Context context, ArrayList<Dish> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int position) {
        return dishes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dishes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_food, parent, false);
        }

        TextView number = view.findViewById(R.id.number);
        TextView food_name = view.findViewById(R.id.food_name);
        TextView price = view.findViewById(R.id.price);

        Dish dish = dishes.get(position);
        number.setText(String.format(Locale.CHINA, "%d", dish.getId()));
        food_name.setText(dish.getName());
        // %3.2f 占三位, 保留两位小数
        price.setText(String.format(Locale.CHINA, "%3.2f", dish.getPrice()));

        return view;
    }
}
