package com.mrfive.presenter;

import android.content.Context;

import com.mrfive.bean.LoginBean;
import com.mrfive.contract.LoginContract;
import com.mrfive.model.LoginModel;

/**
 * Created by lenovo on 2017/11/3.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private LoginModel loginModel;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        loginModel = new LoginModel(this);
    }


    @Override
    public void connectP(Context context, String phone, String password) {

        loginModel.connectP(context,phone,password);
    }

    public void sendData(LoginBean loginBean,String phone,String password){
        if (phone.length()!=11){
            view.onNameError();
            return;
        }
        if (password.length()<6){
            view.onPasswordError();
            return;
        }
        if (loginBean!=null){

            if (loginBean.getData().getMobile().equals(phone) && loginBean.getData().getPassword().equals(password)) {
                view.onSuccess(loginBean);
            }
        }else {
            view.onFailure();
        }

    }
}
