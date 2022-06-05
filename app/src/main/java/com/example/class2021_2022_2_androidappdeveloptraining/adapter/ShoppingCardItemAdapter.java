package com.example.class2021_2022_2_androidappdeveloptraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCardItem;

import java.util.ArrayList;
import java.util.Locale;

class MyViewHolder extends RecyclerView.ViewHolder {
    protected TextView name;
    protected TextView price;
    protected TextView number;
    protected TextView totalPrice;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textView1);
        price = itemView.findViewById(R.id.textView2);
        number = itemView.findViewById(R.id.textView3);
        totalPrice = itemView.findViewById(R.id.textView4);
    }
}

public class ShoppingCardItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<ShoppingCardItem> shoppingCardItems;

    public ShoppingCardItemAdapter(Context context, ArrayList<ShoppingCardItem> shoppingCardItems) {
        this.context = context;
        this.shoppingCardItems = shoppingCardItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.frarmgment_shopping_card_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShoppingCardItem shoppingCardItem = shoppingCardItems.get(position);
        holder.name.setText(shoppingCardItem.getDish().getName());
        holder.price.setText(String.format(Locale.CHINA, "%2.2f", shoppingCardItem.getDish().getPrice()));
        holder.number.setText(String.format(Locale.CHINA, "%2d", shoppingCardItem.getQuantity()));
        holder.totalPrice.setText(String.format(Locale.CHINA, "%3.2f", shoppingCardItem.getItemTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return shoppingCardItems.size();
    }
}