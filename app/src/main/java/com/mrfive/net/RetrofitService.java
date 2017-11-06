package com.mrfive.net;

import com.mrfive.bean.HotBean;
import com.mrfive.bean.LoginBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2017/11/3.
 */

public interface RetrofitService {
    @GET("quarter/user/findHot")
    Observable<HotBean> hotGet();
    @FormUrlEncoded
    @POST("user/login")
    Flowable<LoginBean> loginPost(@Field("mobile") String phone,@Field("password") String password);
    @FormUrlEncoded
    @POST("user/reg")
    Flowable<LoginBean> regPost(@Field("mobile") String phone,@Field("password") String password);
}
