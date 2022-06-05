package com.example.class2021_2022_2_androidappdeveloptraining.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.class2021_2022_2_androidappdeveloptraining.MyApplication;
import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.adapter.DishAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.entity.Dish;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.dialog.GetNumberDialogFragment;

import java.util.ArrayList;

public class MenuFragment extends Fragment implements DishAdapter.OnItemClickListener {

    MyApplication app;

    View view;

    DishAdapter dishAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.framgment_menu, container, false);
        }
        RecyclerView recycler_view = view.findViewById(R.id.recycler_view);
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(app.getDishes_stu().getDish(0));
        dishes.add(app.getDishes_stu().getDish(1));
        dishAdapter = new DishAdapter(getContext(), dishes);
        recycler_view.setAdapter(dishAdapter);
        dishAdapter.setOnItemClickListener(this);
        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (MyApplication) requireActivity().getApplication();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(), "点击了" + position, Toast.LENGTH_LONG).show();
        new GetNumberDialogFragment(0, "getCaipinNumber").show(getParentFragmentManager(), "getCaipinNumber");

        getParentFragmentManager().setFragmentResultListener("getCaipinNumber", MenuFragment.this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Toast.makeText(getContext(), position + "获取到值" + result.getInt("result"), Toast.LENGTH_LONG).show();
                app.getShoppingCart().addItem(app.getDishes_stu().getDishes().get(position), result.getInt("result"));

                Bundle bundle = new Bundle();
                bundle.putInt("id", app.getDishes_stu().getDishes().get(position).getId());
                bundle.putInt("quantity", result.getInt("result"));
                getParentFragmentManager().setFragmentResult("addDishToShoppingCard", bundle);
            }
        });
    }
}
