package com.example.class2021_2022_2_androidappdeveloptraining.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class IsConformDialogFragment extends DialogFragment {
    private String title;
    private String message;

    private String resultId;

    private boolean isConformed;

    public IsConformDialogFragment(String title, String message, String requestId) {
        this.title = title;
        this.message = message;

        this.resultId = requestId;

        this.isConformed = false;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isConformed = true;
                        dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isConformed = false;
                        dismiss();
                    }
                });
        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", isConformed);

        getParentFragmentManager().setFragmentResult(resultId, bundle);
    }
}
