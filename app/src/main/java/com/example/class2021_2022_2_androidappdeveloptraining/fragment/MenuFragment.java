package com.example.class2021_2022_2_androidappdeveloptraining.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.class2021_2022_2_androidappdeveloptraining.MyApplication;
import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.adapter.DishAdapter;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.dialog.GetNumberDialogFragment;

public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener {

    MyApplication app;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.framgment_caipin_list, container, false);
        }
        ListView list_view = view.findViewById(R.id.list_view);
        list_view.setAdapter(new DishAdapter(getContext(), app.getDishes_stu().getDishes()));
        list_view.setOnItemClickListener(this);
        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        list_view_adapter.notifyDataSetChanged();
//    }

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (MyApplication) requireActivity().getApplication();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(), "点击了" + position, Toast.LENGTH_LONG).show();
        new GetNumberDialogFragment(0, "getCaipinNumber").show(getParentFragmentManager(), "getCaipinNumber");

        getParentFragmentManager().setFragmentResultListener("getCaipinNumber", MenuFragment.this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Toast.makeText(parent.getContext(), position + "获取到值" + result.getInt("result"), Toast.LENGTH_LONG).show();
                app.getShoppingCart().addItem(app.getDishes_stu().getDishes().get(position), result.getInt("result"));
            }
        });
    }
}
