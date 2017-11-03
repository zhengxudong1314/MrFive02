package com.mrfive.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.defferentimageview.DefferentImageView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.mrfive.R;
import com.mrfive.fragment.DuanZiFragment;
import com.mrfive.fragment.HomeFragment;
import com.mrfive.fragment.ShiPinFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private com.hjm.bottomtabbar.BottomTabBar btb;
    private android.widget.TextView titleText;
    private com.defferentimageview.DefferentImageView titleHead;
    private android.widget.ImageView biji;
    private android.widget.LinearLayout titlelayout;
    private android.widget.RelativeLayout mainLayout;
    private DefferentImageView myHead;
    private TextView nickName;
    private ImageView sex;
    private android.widget.ListView lv;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private List<String> list_content;
    private List<Integer> list_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initData();
        botomBar();

        ceHuaListView();
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                mainLayout.setX(slideOffset*drawerView.getWidth());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    private void ceHuaListView() {
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list_content.size();
            }

            @Override
            public Object getItem(int i) {
                return list_content.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.cehua_listview_layout, viewGroup, false);
                TextView tv = view.findViewById(R.id.tv);
                ImageView img = view.findViewById(R.id.img);
                tv.setText(list_content.get(i));
                img.setImageResource(list_img.get(i));
                return view;
            }
        });
    }

    private void initData() {
        list_content = new ArrayList<>();
        list_content.add("我的关注");
        list_content.add("我的收藏");
        list_content.add("搜索好友");
        list_content.add("消息通知");
        list_img = new ArrayList<>();
        list_img.add(R.mipmap.xin);
        list_img.add(R.mipmap.xing);
        list_img.add(R.mipmap.sousuo);
        list_img.add(R.mipmap.lingdang);
    }

    //底部导航
    private void botomBar() {
        btb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setChangeColor(Color.RED, Color.parseColor("#8e8e8e"))
                .addTabItem("推荐", R.drawable.tuijian1, R.drawable.tuijian2, HomeFragment.class)
                .addTabItem("段子", R.drawable.duanzi1, R.drawable.duanzi2, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.shipin1, R.drawable.shipin2, ShiPinFragment.class)
                .isShowDivider(true);
        btb.setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {
                titleText.setText(name);
            }
        });
    }

    //初始化控件
    private void initView() {
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.lv = (ListView) findViewById(R.id.lv);
        this.sex = (ImageView) findViewById(R.id.sex);
        this.nickName = (TextView) findViewById(R.id.nickName);
        this.myHead = (DefferentImageView) findViewById(R.id.myHead);
        this.mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        this.btb = (BottomTabBar) findViewById(R.id.btb);
        this.titlelayout = (LinearLayout) findViewById(R.id.title_layout);
        this.biji = (ImageView) findViewById(R.id.biji);
        this.titleText = (TextView) findViewById(R.id.titleText);
        this.titleHead = (DefferentImageView) findViewById(R.id.titleHead);
        titleHead.setType(DefferentImageView.TYPE_CIRCLE);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        myHead.setOnClickListener(this);
        biji.setOnClickListener(this);
        titleHead.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.myHead:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.biji:

                break;
            case R.id.titleHead:
                boolean drawerOpen = drawerLayout.isDrawerOpen(Gravity.LEFT);
                if (drawerOpen) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
    }
}
