package com.atguigu.atguigu_code.banner.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.atguigu.atguigu_code.MyApplication;
import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.banner.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class IndicatorPositionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Banner banner;
    Spinner spinnerPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_position);
        banner = (Banner) findViewById(R.id.banner);
        spinnerPosition= (Spinner) findViewById(R.id.spinnerPosition);
        spinnerPosition.setOnItemSelectedListener(this);

        banner.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                banner.setIndicatorGravity(BannerConfig.LEFT);
                break;
            case 1:
                banner.setIndicatorGravity(BannerConfig.CENTER);
                break;
            case 2:
                banner.setIndicatorGravity(BannerConfig.RIGHT);
                break;
        }
        banner.start();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
