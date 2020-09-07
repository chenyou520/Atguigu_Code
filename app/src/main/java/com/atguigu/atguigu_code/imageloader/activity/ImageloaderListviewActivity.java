package com.atguigu.atguigu_code.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.imageloader.adapter.ImageloaderListviewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageloaderListviewActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.lv_imageloader)
    ListView lvImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageloader_listview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 初始化标题
        tvTitlebarName.setText("Imageloader应用在Listview中");

        ImageloaderListviewAdapter imageloaderListviewAdapter = new ImageloaderListviewAdapter(this);
        lvImageloader.setAdapter(imageloaderListviewAdapter);

    }
}
