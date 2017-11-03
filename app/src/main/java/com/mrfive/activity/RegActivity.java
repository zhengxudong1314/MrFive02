package com.mrfive.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mrfive.R;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.ImageView back;
    private android.widget.ImageView logo;
    private android.widget.EditText phone;
    private android.widget.EditText password;
    private android.widget.Button register;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:

                break;

        }
    }
}
