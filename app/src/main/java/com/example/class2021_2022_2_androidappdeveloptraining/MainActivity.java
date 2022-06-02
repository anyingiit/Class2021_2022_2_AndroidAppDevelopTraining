package com.example.class2021_2022_2_androidappdeveloptraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyApplication app;
    private Context context;

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
                // MainActivity.this 实际上就是我们把自己的运行时传过去然后dialog用这个运行时(也就是我们本身)去执行一些东西, 权限应该和自身是相同的
                final LoginDialog_stu loginDialog = new LoginDialog_stu(MainActivity.this);
                loginDialog.show();
                loginDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        switch (loginDialog.getButtonStatus()) {
                            case Login:
                                System.out.println(loginDialog.getUsername());
                                System.out.println(loginDialog.getPassword());
//                                login.setText("注销");
                                break;
                            case Register:
                                System.out.println(loginDialog.getUsername());
                                System.out.println(loginDialog.getPassword());
                                break;
                            default:
                                break;

                        }
                    }
                });
            }
        });
    }

//    private class ButtonsListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
}