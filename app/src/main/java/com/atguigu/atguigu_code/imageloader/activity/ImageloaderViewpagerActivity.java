package com.atguigu.atguigu_code.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.imageloader.adapter.ImageloaderViewpagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageloaderViewpagerActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.vp_imageloader_viewpager)
    ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_viewpager);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitlebarName.setText("Imageloader应用在viewpager中");

        // 初始化viewpager
        ImageloaderViewpagerAdapter imageloaderViewpagerAdapter = new ImageloaderViewpagerAdapter(this);

        vpImageloaderViewpager.setAdapter(imageloaderViewpagerAdapter);

        vpImageloaderViewpager.setCurrentItem(1);
    }
}
