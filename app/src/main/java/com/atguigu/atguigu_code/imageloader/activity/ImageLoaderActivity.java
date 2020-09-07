package com.atguigu.atguigu_code.imageloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageLoaderActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.bt_imageloader_listview)
    Button btImageloaderListview;
    @Bind(R.id.bt_imageloader_gridview)
    Button btImageloaderGridview;
    @Bind(R.id.bt_imageloader_viewpager)
    Button btImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitlebarName.setText("Imageloader");
    }

    @OnClick({R.id.bt_imageloader_listview, R.id.bt_imageloader_gridview, R.id.bt_imageloader_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_imageloader_listview:
                // 跳转到listview案例页面
                Intent intent = new Intent(ImageLoaderActivity.this, ImageloaderListviewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_imageloader_gridview:
                // 跳转到gridview案例页面
                Intent intent1 = new Intent(ImageLoaderActivity.this, ImageloaderGridviewActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_imageloader_viewpager:
                // 跳转到viewpager案例页面
                Intent intent2 = new Intent(ImageLoaderActivity.this, ImageloaderViewpagerActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
