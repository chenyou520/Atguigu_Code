package com.atguigu.atguigu_code.picasso.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.picasso.adapter.PicassoListviewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoListviewActivity extends AppCompatActivity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.lv_picasso)
    ListView lvPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_listview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 标题
        tvTitlebarName.setText("Picasso在listview中使用");
        // 初始化listview
        PicassoListviewAdapter picassoListviewAdapter = new PicassoListviewAdapter(this);
        lvPicasso.setAdapter(picassoListviewAdapter);
    }
}
