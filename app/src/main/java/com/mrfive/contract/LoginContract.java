package com.mrfive.contract;

/**
 * Created by lenovo on 2017/11/3.
 */

public interface LoginContract {
    interface Model {
        void connectP();
    }

    interface View {
        void onNameError();

        void onPasswordError();

        void onFailure();

        void onSuccess();
    }

    interface Presenter {
        void connectV();
    }
}
