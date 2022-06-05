package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RegisterActivity extends Activity {
    private MyApplication app;


    EditText username;
    EditText password;
    EditText passwordConform;
    EditText phone;
    EditText address;

    Button register;
    Button cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        app = (MyApplication) getApplication();

        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        passwordConform = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText4);
        address = findViewById(R.id.editText5);

        register = findViewById(R.id.button1);
        cancel = findViewById(R.id.button2);

        Intent fatherIntent = getIntent();
        username.setText(fatherIntent.getStringExtra("username"));
        password.setText(fatherIntent.getStringExtra("password"));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwordString = password.getText().toString();
                String passwordConformString = passwordConform.getText().toString();
                if (!passwordString.equals(passwordConformString)) {
                    Toast.makeText(RegisterActivity.this, "密码输入不一致, 请重新输入!", Toast.LENGTH_LONG).show();
                    return;
                }

                String usernameString = username.getText().toString();

                if (app.getUsers().findUserByUsername(usernameString) != null) {
                    Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_LONG).show();
                    return;
                }

                String phoneString = phone.getText().toString();
                if (app.getUsers().findUserByPhone(phoneString) != null) {
                    Toast.makeText(RegisterActivity.this, "手机号已被注册", Toast.LENGTH_LONG).show();
                    return;
                }

                String addressString = address.getText().toString();

                app.getUsers().addUser(usernameString, passwordString, phoneString, addressString);

                Intent intent = new Intent();
                intent.putExtra("username", usernameString);
                intent.putExtra("password", passwordString);
                intent.putExtra("phone", phoneString);
                intent.putExtra("address", addressString);

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);

                finish();
            }
        });
    }
}
