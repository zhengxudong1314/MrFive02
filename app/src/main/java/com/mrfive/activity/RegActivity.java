package com.mrfive.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mrfive.R;
import com.mrfive.bean.LoginBean;
import com.mrfive.contract.RegisterContract;
import com.mrfive.presenter.RegisterPresenter;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,RegisterContract.View {

    private android.widget.ImageView back;
    private android.widget.ImageView logo;
    private android.widget.EditText phone;
    private android.widget.EditText password;
    private android.widget.Button register;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        this.register = (Button) findViewById(R.id.register);
        this.password = (EditText) findViewById(R.id.password);
        this.phone = (EditText) findViewById(R.id.phone);
        this.logo = (ImageView) findViewById(R.id.logo);
        this.back = (ImageView) findViewById(R.id.back);
        register.setOnClickListener(this);
        back.setOnClickListener(this);
        registerPresenter = new RegisterPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:
                String phone1 = phone.getText().toString();
                String pwd = password.getText().toString();

                registerPresenter.connectP(this,phone1,pwd);
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
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
}
