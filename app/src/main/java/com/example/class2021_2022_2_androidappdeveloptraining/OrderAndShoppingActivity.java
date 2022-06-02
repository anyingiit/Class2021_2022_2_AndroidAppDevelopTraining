package com.example.class2021_2022_2_androidappdeveloptraining;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.class2021_2022_2_androidappdeveloptraining.adapter.ViewAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.CaipinFramgment;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.OrderFragment;

import java.util.ArrayList;


public class OrderAndShoppingActivity extends FragmentActivity {

    private ViewPager2 vp_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_and_shopping_activity);
        initPager();
    }

    private void initPager() {
        vp_content = findViewById(R.id.vp_content);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CaipinFramgment());
        fragments.add(new OrderFragment());
        ViewAdapter viewPager = new ViewAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        vp_content.setAdapter(viewPager);
    }
}
