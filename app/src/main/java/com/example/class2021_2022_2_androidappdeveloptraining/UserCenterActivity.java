package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.User;

public class UserCenterActivity extends Activity {
    private MyApplication app;

    private User user;

    TextView username;
    EditText passwordCheck;
    EditText phone;
    EditText address;

    Button editUserInfo;
    Button back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_stu);

        app = (MyApplication) getApplication();

        Intent intent = getIntent();
        int userId = intent.getIntExtra("userId", -1);
        if (userId == -1) {
            Toast.makeText(UserCenterActivity.this, "发生内部错误, 未传入user ID", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        user = app.getUsers().getUserById(userId);

        username = findViewById(R.id.textView1);
        passwordCheck = findViewById(R.id.editText1);
        phone = findViewById(R.id.editText2);
        address = findViewById(R.id.editText3);

        editUserInfo = findViewById(R.id.button1);
        back = findViewById(R.id.button2);

        username.setText(user.getmUsername_stu());

        editUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwordCheckString = passwordCheck.getText().toString();
                if (passwordCheckString.equals("") || !passwordCheckString.equals(user.getmPassword_stu())) {
                    Toast.makeText(UserCenterActivity.this, "密码验证失败, 请正确输入您的密码", Toast.LENGTH_LONG).show();
                    return;
                }

                user.setmUserPhone_stu(phone.getText().toString());
                user.setmUserAddress_stu(address.getText().toString());
                Toast.makeText(UserCenterActivity.this, "修改完成", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
