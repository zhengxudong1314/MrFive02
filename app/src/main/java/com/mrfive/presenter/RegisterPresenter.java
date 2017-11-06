package com.mrfive.presenter;

import android.content.Context;

import com.mrfive.bean.LoginBean;
import com.mrfive.contract.RegisterContract;
import com.mrfive.model.RegisterModel;

/**
 * Created by lenovo on 2017/11/3.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        registerModel = new RegisterModel(this);
    }


    @Override
    public void connectP(Context context, String phone, String password) {

        registerModel.connectP(context,phone,password);
    }

    public void sendData(LoginBean loginBean, String phone, String password){
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
