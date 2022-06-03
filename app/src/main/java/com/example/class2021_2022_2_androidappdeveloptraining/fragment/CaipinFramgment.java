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

import com.example.class2021_2022_2_androidappdeveloptraining.MyApplication;
import com.example.class2021_2022_2_androidappdeveloptraining.R;
import com.example.class2021_2022_2_androidappdeveloptraining.adapter.CaiPinAdapter;

public class CaipinFramgment extends Fragment implements AdapterView.OnItemClickListener {

    MyApplication app;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.framgment_caipin_list_stu, container, false);
        }
        ListView list_view = view.findViewById(R.id.list_view);
        list_view.setAdapter(new CaiPinAdapter(getContext(), app.getDishes_stu().getRow()));
        list_view.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (MyApplication) getActivity().getApplication();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(), "点击了" + position, Toast.LENGTH_LONG).show();
    }
}
