package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {
    public enum options {Login, Register, Cancel}

    private options buttonStatus = options.Cancel;


    EditText username;
    EditText password;

    Button register;
    Button login;
    Button cancel;

    CheckBox rememberedUsername;


    public LoginDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);

        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);

        register = findViewById(R.id.button1);
        login = findViewById(R.id.button2);
        cancel = findViewById(R.id.button3);

        rememberedUsername = findViewById(R.id.checkbox1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStatus = options.Register;
                dismiss();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStatus = options.Login;
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStatus = options.Cancel;
                dismiss();
            }
        });
    }

    public String getUsername() {
        return username.getText().toString();
    }

    public String getPassword() {
        return password.getText().toString();
    }

    public boolean getIsRememberUsername() {
        return rememberedUsername.isChecked();
    }

    public options getButtonStatus() {
        return buttonStatus;
    }
}
