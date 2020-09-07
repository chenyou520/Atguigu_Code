package com.atguigu.atguigu_code.glide.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.bt_glide_base)
    Button btGlideBase;
    @Bind(R.id.bt_glide_recyclerview)
    Button btGlideRecyclerview;
    @Bind(R.id.bt_glide_tranfromations)
    Button btGlideTranfromations;
    @Bind(R.id.activity_glide)
    LinearLayout activityGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("Glide");
    }

    @OnClick({R.id.bt_glide_base, R.id.bt_glide_recyclerview, R.id.bt_glide_tranfromations})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_glide_base:// 基本使用
                Intent intent = new Intent(GlideActivity.this, GlideBaseActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_glide_recyclerview: // 在Recyclerview中使用
                Intent intent1 = new Intent(GlideActivity.this, GlideRecyclerviewActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_glide_tranfromations:// 图片变换
                Intent intent2 = new Intent(GlideActivity.this, GlideTranformationsActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
