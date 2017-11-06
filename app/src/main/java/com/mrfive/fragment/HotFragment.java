package com.mrfive.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrfive.R;
import com.mrfive.adapter.HotAdapter;
import com.mrfive.bean.HotBean;
import com.mrfive.contract.HomeContract;
import com.mrfive.presenter.HomePresenter;

import java.util.List;

/**
 * Created by lenovo on 2017/11/3.
 */

public class HotFragment extends Fragment implements HomeContract.View{
    private android.support.v7.widget.RecyclerView rv;
    private android.support.v4.widget.SwipeRefreshLayout sw;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_fragment, null);
        this.sw = (SwipeRefreshLayout) view.findViewById(R.id.sw);
        this.rv = (RecyclerView) view.findViewById(R.id.rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.connectP();
    }

    @Override
    public void getHotData(HotBean hotBean) {
        List<HotBean.ResourceBean> list = hotBean.getResource();
        HotAdapter hotAdapter = new HotAdapter(getActivity(),list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(hotAdapter);
    }

}
