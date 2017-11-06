package com.mrfive.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mrfive.R;
import com.mrfive.bean.HotBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/3.
 */

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HotBean.ResourceBean> list;
    private com.facebook.drawee.view.SimpleDraweeView img1;
    private android.widget.ImageView delete;
    private android.widget.TextView tv1;
    private android.widget.TextView tv2;
    private android.widget.TextView tv3;
    private android.widget.TextView tv4;
    private String path = "http://pic21.photophoto.cn/20111106/0020032891433708_b.jpg";
    private SimpleDraweeView img3;

    public HotAdapter(Context context, List<HotBean.ResourceBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_show, parent, false);
        this.tv4 = (TextView) view.findViewById(R.id.tv4);
        this.img3 = (SimpleDraweeView) view.findViewById(R.id.img3);
        this.tv3 = (TextView) view.findViewById(R.id.tv3);
        this.tv2 = (TextView) view.findViewById(R.id.tv2);
        this.tv1 = (TextView) view.findViewById(R.id.tv1);
        this.delete = (ImageView) view.findViewById(R.id.delete);
        this.img1 = (SimpleDraweeView) view.findViewById(R.id.img1);
        MyViewHolder02 myViewHolder02 = new MyViewHolder02(view);
        return myViewHolder02;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        tv1.setText("天蝎喝牛奶");
        tv2.setText("2017-05-23 14:25");
        tv3.setText("天气美美的，适合郊游");
        tv4.setText("骑猪上高速：不错");
        img1.setImageURI(Uri.parse(path));
        img3.setImageURI(Uri.parse(path));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder01 extends RecyclerView.ViewHolder {

        public MyViewHolder01(View itemView) {
            super(itemView);
        }
    }

    class MyViewHolder02 extends RecyclerView.ViewHolder {

        public MyViewHolder02(View itemView) {
            super(itemView);
        }
    }
}
