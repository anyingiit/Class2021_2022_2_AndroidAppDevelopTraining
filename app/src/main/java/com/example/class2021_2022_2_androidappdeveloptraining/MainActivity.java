package com.example.class2021_2022_2_androidappdeveloptraining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import com.example.class2021_2022_2_androidappdeveloptraining.entity.User;
import com.example.class2021_2022_2_androidappdeveloptraining.fragment.IsConformDialogFragment;

public class MainActivity extends AppCompatActivity {
    private MyApplication app;
    private Context context;

    private enum REQUEST_CODE {
        Register,
        UserCenter,
        Order,
        TackOut,
        myOrder
    }

    Button orderFood;
    Button takeOut;
    Button userCenter;
    Button login;
    Button myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (MyApplication) getApplication();
        context = getApplicationContext();


        orderFood = findViewById(R.id.button1);
        takeOut = findViewById(R.id.button2);
        userCenter = findViewById(R.id.button3);
        login = findViewById(R.id.button4);
        myOrder = findViewById(R.id.button5);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (app.IsUserLogin()) {
                    new IsConformDialogFragment("确定吗", "确定注销吗", "conformLogoutOption").show(getSupportFragmentManager(), "conformLogoutOption");
                    getSupportFragmentManager().setFragmentResultListener("conformLogoutOption", MainActivity.this, new FragmentResultListener() {
                        @Override
                        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                            if (result.getBoolean("result")) {
                                app.setUserLogout();
                                login.setTextSize(30);
                                String welComeString = "登录";
                                login.setText(welComeString);
                            }
                        }
                    });
                    return;
                }
                // MainActivity.this 实际上就是我们把自己的运行时传过去然后dialog用这个运行时(也就是我们本身)去执行一些东西, 权限应该和自身是相同的
                final LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                loginDialog.show();
                loginDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        switch (loginDialog.getButtonStatus()) {
                            case Login:
                                String username = loginDialog.getUsername();
                                String password = loginDialog.getPassword();
                                System.out.println(username);
                                System.out.println(loginDialog.getPassword());

                                login(username, password);
                                break;
                            case Register:
                                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                                intent.putExtra("username", loginDialog.getUsername());
                                intent.putExtra("password", loginDialog.getPassword());
                                startActivityForResult(intent, REQUEST_CODE.Register.ordinal());
                                break;
                            default:
                                break;

                        }
                    }
                });
            }
        });

        userCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!app.IsUserLogin()) {
                    Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_LONG).show();
                    return;
                }


                Intent intent = new Intent(MainActivity.this, UserCenterActivity.class);
                User user = app.getLoginUser();
                intent.putExtra("userId", user.getmUserId_stu());
                startActivityForResult(intent, REQUEST_CODE.UserCenter.ordinal());
            }
        });

        orderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!app.IsUserLogin()) {
                    Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_LONG).show();
                    return;
                }


                Intent intent = new Intent(MainActivity.this, OrderAndShoppingActivity.class);
                startActivity(intent);
            }
        });

        takeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "敬请期待!", Toast.LENGTH_LONG).show();
                return;

//                if (!app.IsUserLogin()) {
//                    Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_LONG).show();
//                    return;
//                }
            }
        });

        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "敬请期待!", Toast.LENGTH_LONG).show();
                return;

//                if (!app.IsUserLogin()) {
//                    Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_LONG).show();
//                    return;
//                }
            }
        });
    }

    private void login(String username, String password) {
        User user = app.getUsers().findUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getmPassword_stu())) {
                app.userLogin(user);
                login.setTextSize(20);
                login.setText(username);
                Toast.makeText(MainActivity.this, "欢迎你, " + username + "!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE.Register.ordinal()) {
            if (resultCode == Activity.RESULT_OK) {
                assert data != null;

                String username = data.getStringExtra("username");
                String password = data.getStringExtra("password");
                login(username, password);
            }
        } else if (requestCode == REQUEST_CODE.UserCenter.ordinal()) {
            if (requestCode == Activity.RESULT_OK) {
                app.setUserLogout();
            }
        }

    }

    private void IsConformDialog(String message, DialogInterface.OnClickListener positiveCallback) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("确定要执行操作吗?")
                .setMessage(message)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", positiveCallback).create();

        alertDialog.show();
    }
}