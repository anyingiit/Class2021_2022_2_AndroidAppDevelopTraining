package com.example.class2021_2022_2_androidappdeveloptraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;

import java.util.ArrayList;
import java.util.Locale;

class DishAdapterViewHolder extends RecyclerView.ViewHolder {
    TextView number;
    TextView food_name;
    TextView price;

    public DishAdapterViewHolder(@NonNull View itemView) {
        super(itemView);

        number = itemView.findViewById(R.id.number);
        food_name = itemView.findViewById(R.id.food_name);
        price = itemView.findViewById(R.id.price);
    }
}

public class DishAdapter extends RecyclerView.Adapter<DishAdapterViewHolder> {

    Context context;
    ArrayList<Dish> dishes;

    OnItemClickListener listener;

    /**
     * @param context 上下文, 即adapter附着的对象
     * @param dishes  期望使用adapter处理的数据集合, 这里传入的是菜品的列表
     */
    public DishAdapter(Context context, ArrayList<Dish> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DishAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_menu_item, parent, false);
        return new DishAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapterViewHolder holder, int position) {
        Dish dish = dishes.get(position);

        holder.number.setText(String.format(Locale.CHINA, "%d", dish.getId()));
        holder.food_name.setText(dish.getName());
        holder.price.setText(String.format(Locale.CHINA, "%3.2f", dish.getPrice()));// %3.2f 占三位, 保留两位小数

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }
}
