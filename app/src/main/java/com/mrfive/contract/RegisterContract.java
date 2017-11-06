package com.mrfive.contract;

import android.content.Context;

import com.mrfive.bean.LoginBean;

/**
 * Created by lenovo on 2017/11/3.
 */

public interface RegisterContract {
    interface Model {
        void connectP(Context context, String phone, String password);
    }

    interface View {
        void onNameError();

        void onPasswordError();

        void onFailure();

        void onSuccess(LoginBean loginBean);

    }

    interface Presenter {
        void connectP(Context context,String phone,String password);
    }
}
