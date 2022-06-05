package com.example.class2021_2022_2_androidappdeveloptraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCardItem;

import java.util.ArrayList;
import java.util.Locale;

public class ShoppingCardItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<ShoppingCardItem> shoppingCardItems;

    View view;

    public ShoppingCardItemAdapter(Context context, ArrayList<ShoppingCardItem> shoppingCardItems) {
        this.context = context;
        this.shoppingCardItems = shoppingCardItems;
    }

    @Override
    public int getCount() {
        return shoppingCardItems.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingCardItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.frarmgment_order_item, parent, false);
        }

        TextView name = view.findViewById(R.id.textView1);
        TextView price = view.findViewById(R.id.textView2);
        TextView number = view.findViewById(R.id.textView3);
        TextView totalPrice = view.findViewById(R.id.textView4);

        ShoppingCardItem shoppingCardItem = shoppingCardItems.get(position);
        name.setText(shoppingCardItem.getDish().getName());
        price.setText(String.format(Locale.CHINA, "%2.2f", shoppingCardItem.getDish().getPrice()));
        number.setText(String.format(Locale.CHINA, "%2d", shoppingCardItem.getQuantity()));
        totalPrice.setText(String.format(Locale.CHINA, "%3.2f", shoppingCardItem.getItemTotalPrice()));

        return view;
    }
}
