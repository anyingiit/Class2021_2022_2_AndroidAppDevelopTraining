package com.example.class2021_2022_2_androidappdeveloptraining.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.class2021_2022_2_androidappdeveloptraining.R;

import java.util.Locale;

public class GetNumberDialogFragment extends DialogFragment {

    private String requestId;

    private int curNumber;

    private boolean isConform;

    public GetNumberDialogFragment(int curNumber, String requestId) {
        this.curNumber = curNumber;
        this.requestId = requestId;

        this.isConform = false;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.framgment_get_number, null);
        Button add = view.findViewById(R.id.add);
        Button sub = view.findViewById(R.id.sub);
        EditText editText = view.findViewById(R.id.editText1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curNumber = curNumber >= 9 ? 9 : curNumber + 1;
                editText.setText(String.format(Locale.CHINA, "%d", curNumber));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curNumber = curNumber <= 0 ? 0 : curNumber - 1;
                editText.setText(String.format(Locale.CHINA, "%d", curNumber));
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.getText().toString().equals("")) {
                    return;
                }
                int numberTemp = Integer.parseInt(editText.getText().toString());
                if (numberTemp > 9) {
                    editText.setText(String.format(Locale.CHINA, "%d", 9));
                    curNumber = 9;
                } else if (numberTemp < 0) {
                    editText.setText(String.format(Locale.CHINA, "%d", 0));
                    curNumber = 0;
                } else {
                    curNumber = numberTemp;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        builder.setView(view)
                .setTitle("选择数量")
                .setMessage("请选择")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isConform = true;
                    }
                });

        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!isConform) {
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("result", curNumber);
        getParentFragmentManager().setFragmentResult(requestId, bundle);
    }
}
