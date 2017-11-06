package com.mrfive.contract;

import com.mrfive.bean.HotBean;

/**
 * Created by lenovo on 2017/11/3.
 */

public interface HomeContract {
    interface Model {
        void connectP();
    }

    interface View {
        void getHotData(HotBean hotBean);
    }

    interface Presenter {
        void connectP();
    }
}
