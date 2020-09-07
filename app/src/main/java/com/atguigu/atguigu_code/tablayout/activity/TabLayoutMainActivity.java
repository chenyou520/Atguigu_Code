package com.atguigu.atguigu_code.tablayout.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.tablayout.adapter.ViewPagerAdapter;
import com.atguigu.atguigu_code.tablayout.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabLayoutMainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_titlebar_name;
    private TabLayout tabLayout;
    private ArrayList<MyFragment> fragments;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);
        tv_titlebar_name = (TextView) findViewById(R.id.tv_titlebar_name);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tv_titlebar_name.setText("TabLayout的使用");

        //初始化数据
        fragments = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            fragments.add(new MyFragment("title" + i, "内容" + i));
        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
