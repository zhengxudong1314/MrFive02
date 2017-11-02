package com.mrfive.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mrfive.R;
import com.mrfive.fragment.DaoHang01;
import com.mrfive.fragment.DaoHang02;
import com.mrfive.fragment.DaoHang03;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v4.widget.DrawerLayout drawer;
    private android.widget.RelativeLayout homeactivity;
    private android.support.v4.view.ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        final List<Fragment> list = new ArrayList<>();
        list.add(new DaoHang01());
        list.add(new DaoHang02());
        list.add(new DaoHang03());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }
}
