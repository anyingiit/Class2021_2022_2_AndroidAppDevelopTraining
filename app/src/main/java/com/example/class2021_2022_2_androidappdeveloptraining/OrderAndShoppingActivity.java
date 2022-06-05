package com.example.class2021_2022_2_androidappdeveloptraining;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.class2021_2022_2_androidappdeveloptraining.adapter.FragmentAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.CaipinFramgment;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.OrderFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class OrderAndShoppingActivity extends FragmentActivity {

    private ViewPager2 vp_content;
    private com.google.android.material.tabs.TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_and_shopping_activity);
        initPager();

        tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, vp_content, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position == 0 ? "点餐" : "购物车");
            }
        }).attach();
    }

    private void initPager() {
        vp_content = findViewById(R.id.vp_content);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CaipinFramgment());
        fragments.add(new OrderFragment());
        FragmentAdapter viewPager = new FragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        vp_content.setAdapter(viewPager);
    }
}
