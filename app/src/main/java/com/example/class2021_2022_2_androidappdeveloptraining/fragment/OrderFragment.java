package com.example.class2021_2022_2_androidappdeveloptraining.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.class2021_2022_2_androidappdeveloptraining.MyApplication;
import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.adapter.ShoppingCardItemAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCardItem;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    BaseAdapter listViewAdapter;
    ListView listView;

    ArrayList<ShoppingCardItem> shoppingCardItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framgment_ordered, container, false);
        MyApplication app = (MyApplication) requireActivity().getApplication();
        shoppingCardItems = new ArrayList<>();
        listViewAdapter = new ShoppingCardItemAdapter(getContext(), shoppingCardItems);
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(listViewAdapter);

        Button add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingCardItems.add(new ShoppingCardItem(new Dish((int) (Math.random() * 100), Integer.toString((int) (Math.random() * 100)), (int) (Math.random() * 100), (float) (Math.random() * 100)), 1));
                for (ShoppingCardItem item :
                        shoppingCardItems) {
                    System.out.println(item.getDish_stu().getId());
                }
                listViewAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
