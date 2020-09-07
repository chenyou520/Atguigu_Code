package com.atguigu.atguigu_code.android_pulltorefresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PullToRefreshMainActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.listview, R.id.gridview, R.id.fragment, R.id.viewpager, R.id.viewpager2, R.id.webview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.listview:
                startActivity(new Intent(this,PullToRefreshListActivity.class));
                break;
            case R.id.gridview:
                startActivity(new Intent(this,PullToRefreshGridActivity.class));
                break;
            case R.id.fragment:
                startActivity(new Intent(this,PullToRefreshListFragmentActivity.class));
                break;
            case R.id.viewpager:
                startActivity(new Intent(this,PullToRefreshListInViewPagerActivity.class));
                break;
            case R.id.viewpager2:
                startActivity(new Intent(this,PullToRefreshViewPagerActivity.class));
                break;
            case R.id.webview:
                startActivity(new Intent(this,PullToRefreshWebViewActivity.class));
                break;
        }
    }
}
