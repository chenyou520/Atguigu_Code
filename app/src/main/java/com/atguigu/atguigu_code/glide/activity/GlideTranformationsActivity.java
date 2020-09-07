package com.atguigu.atguigu_code.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.glide.adapter.GlideTranformationsAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideTranformationsActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.rv_glide_transformations)
    RecyclerView rvGlideTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_tranformations);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("Glide图形变换");

        // 初始化Recyclerview
//        GlideTranformationsAdapter glideTranformationsAdapter = new GlideTranformationsAdapter(this);
//        rvGlideTransformations.setAdapter(glideTranformationsAdapter);
//        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 初始化Recyclerview
        GlideTranformationsAdapter glideTranformationsAdapter = new GlideTranformationsAdapter(this);
        rvGlideTransformations.setAdapter(glideTranformationsAdapter);
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
