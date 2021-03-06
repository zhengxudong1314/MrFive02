package com.mrfive.model;

import android.content.Context;

import com.mrfive.bean.LoginBean;
import com.mrfive.contract.LoginContract;
import com.mrfive.net.RetrofitService;
import com.mrfive.presenter.LoginPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/11/3.
 */

public class LoginModel implements LoginContract.Model {
    private LoginPresenter loginPresenter;
    private String url = "http://120.27.23.105/";

    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Override
    public void connectP(Context context, final String phone, final String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //支持Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //支持rxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //动态代理获取retrofitService
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Flowable<LoginBean> flowable = retrofitService.loginPost(phone, password);
        //异步
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (loginBean.getCode().equals("0")) {
                            loginPresenter.sendData(loginBean, phone, password);
                        }else {
                            loginPresenter.sendData(null, phone, password);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
