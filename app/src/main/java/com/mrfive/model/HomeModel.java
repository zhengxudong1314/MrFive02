package com.mrfive.model;

import com.mrfive.bean.HotBean;
import com.mrfive.contract.HomeContract;
import com.mrfive.net.RetrofitService;
import com.mrfive.presenter.HomePresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by lenovo on 2017/11/3.
 */

public class HomeModel implements HomeContract.Model {
    private HomePresenter homePresenter;
    private String url = "http://172.17.29.27/";
    public HomeModel(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @Override
    public void connectP() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //支持Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //支持rxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //动态代理获取retrofitService
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<HotBean> observable = retrofitService.hotGet();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotBean>() {
                    @Override
                    public void accept(HotBean hotBean) throws Exception {
                        homePresenter.sendData(hotBean);
                    }
                });
    }
}
