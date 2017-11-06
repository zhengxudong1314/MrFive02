package com.mrfive.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrfive.R;
import com.mrfive.bean.LoginBean;
import com.mrfive.contract.LoginContract;
import com.mrfive.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginContract.View {

    private android.widget.ImageView back;
    private android.widget.TextView register;
    private android.widget.ImageView logo;
    private android.widget.EditText phone;
    private android.widget.EditText password;
    private android.widget.Button login;
    private android.widget.TextView forget;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        this.forget = (TextView) findViewById(R.id.forget);
        this.login = (Button) findViewById(R.id.login);
        this.password = (EditText) findViewById(R.id.password);
        this.phone = (EditText) findViewById(R.id.phone);
        this.logo = (ImageView) findViewById(R.id.logo);
        this.register = (TextView) findViewById(R.id.register);
        this.back = (ImageView) findViewById(R.id.back);
        forget.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:
                startActivity(new Intent(this, RegActivity.class));
                break;
            case R.id.login:
                String phone1 = phone.getText().toString();
                String pwd = password.getText().toString();

                loginPresenter.connectP(this,phone1,pwd);
                break;
            case R.id.forget:

                break;
        }
    }

    @Override
    public void onNameError() {
        phone.setError("请输入正确的手机号码");
    }

    @Override
    public void onPasswordError() {
        password.setError("密码不能小于6位");
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }


}
