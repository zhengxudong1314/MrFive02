package com.mrfive.presenter;

import com.mrfive.bean.HotBean;
import com.mrfive.contract.HomeContract;
import com.mrfive.model.HomeModel;

/**
 * Created by lenovo on 2017/11/3.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private HomeModel homeModel;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        homeModel = new HomeModel(this);
    }

    @Override
    public void connectP() {
        homeModel.connectP();
    }

    public void sendData(HotBean hotBean){
        view.getHotData(hotBean);
    }
}
