package com.example.class2021_2022_2_androidappdeveloptraining.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.class2021_2022_2_androidappdeveloptraining.MyApplication;
import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.adapter.ShoppingCardItemAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCard;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.ShoppingCardItem;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.dialog.GetNumberDialogFragment;

public class ShoppingCardFragment extends Fragment implements ShoppingCardItemAdapter.OnItemClickListener {
    ShoppingCard shoppingCard;

    MyApplication app;

    ShoppingCardItemAdapter shoppingCardItemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.app = (MyApplication) requireActivity().getApplication();
        this.shoppingCard = new ShoppingCard(app.getLoginUser().getUsername());

        View view = inflater.inflate(R.layout.framgment_shoppping_card, container, false);
        this.shoppingCardItemAdapter = new ShoppingCardItemAdapter(getContext(), shoppingCard.getShoppingCardItems());
        RecyclerView recyclerView = view.findViewById(R.id.list_view);
        recyclerView.setAdapter(shoppingCardItemAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        shoppingCardItemAdapter.setOnItemClickListener(this);

        Button add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingCard.addItem(new Dish((int) (Math.random() * 100), Integer.toString((int) (Math.random() * 100)), (int) (Math.random() * 100), (float) (Math.random() * 100)), 1);
                for (ShoppingCardItem item :
                        shoppingCard.getShoppingCardItems()) {
                    System.out.println(item.getDish().getId() + " " + item.getDish().getName());
                }
                System.out.println();
                shoppingCardItemAdapter.notifyDataSetChanged();
            }
        });

        getParentFragmentManager().setFragmentResultListener("addDishToShoppingCard", ShoppingCardFragment.this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int dishId = result.getInt("id");
                Dish dish = app.getDishes_stu().findDishByDishId(dishId);
                if (dish == null) {
                    Toast.makeText(getContext(), "购物车添加菜品发生错误, 未找到菜品ID" + dishId, Toast.LENGTH_LONG).show();
                    return;
                }
                int quantity = result.getInt("quantity");

                shoppingCard.addItem(dish, quantity);
                shoppingCardItemAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }


    @Override
    public void onItemClick(int position) {
        ShoppingCardItem shoppingCardItem = shoppingCard.getItem(position);
        System.out.println(position);
        int quantity = shoppingCardItem.getQuantity();
        new GetNumberDialogFragment(quantity, "onShoppingCardGetItemNewQuantity").show(getParentFragmentManager(), "onShoppingCardGetItemNewQuantity");

        getParentFragmentManager().setFragmentResultListener("onShoppingCardGetItemNewQuantity", ShoppingCardFragment.this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int quantityResult = result.getInt("result");
                if (quantityResult == 0) {
                    shoppingCard.deleteItem(position);
                } else {
                    shoppingCardItem.setQuantity(quantityResult);
                }

                shoppingCardItemAdapter.notifyDataSetChanged();
            }
        });
    }
}
