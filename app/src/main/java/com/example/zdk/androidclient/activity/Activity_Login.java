package com.example.zdk.androidclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zdk.androidclient.R;
import com.example.zdk.androidclient.model.UserInfoModel;

public class Activity_Login extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private Button bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getViewId();
        addListener();
    }

    /**
     * 添加监听器
     */
    private void addListener() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfoModel.userLogin(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });
    }

    /**
     * 获取View ID
     */
    private void getViewId() {
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        bt_login=findViewById(R.id.btn_login);
    }
}
