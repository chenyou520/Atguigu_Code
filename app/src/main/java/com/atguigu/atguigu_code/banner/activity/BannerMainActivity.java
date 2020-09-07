package com.atguigu.atguigu_code.banner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.atguigu.atguigu_code.MyApplication;
import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.banner.SuperSwipeRefreshLayout;
import com.atguigu.atguigu_code.banner.adapter.SampleAdapter;
import com.atguigu.atguigu_code.banner.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BannerMainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener, OnBannerListener {
    static final int REFRESH_COMPLETE = 0X1112;
    SuperSwipeRefreshLayout mSwipeLayout;
    ListView listView;
    Banner banner;
    private TextView tv_titlebar_name;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    String[] urls = getResources().getStringArray(R.array.url4);
                    List list = Arrays.asList(urls);
                    List arrayList = new ArrayList(list);
                    banner.update(arrayList);
                    mSwipeLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_main);
        //初始化布局
        mSwipeLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeLayout.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.list);
        tv_titlebar_name = (TextView) findViewById(R.id.tv_titlebar_name);
        tv_titlebar_name.setText("Banner横幅广告");
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        banner = (Banner) header.findViewById(R.id.banner);
        //设置banner的参数--宽高
        banner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, MyApplication.H / 4));
        //把banner设为 listview的头部
        listView.addHeaderView(banner);

        //获取数据
        String[] data = getResources().getStringArray(R.array.demo_list);
        //设置适配器
        listView.setAdapter(new SampleAdapter(this, data));
        //设置item的点击监听
        listView.setOnItemClickListener(this);

        //简单使用
        banner.setImages(MyApplication.images)//加载图片
                .setImageLoader(new GlideImageLoader())//添加自定义的图片加载器
                .setOnBannerListener(this)
                .start();

    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getApplicationContext(), "你点击了：" + position, Toast.LENGTH_SHORT).show();
    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }


    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1://设置动画样式
                startActivity(new Intent(this, BannerAnimationActivity.class));
                break;
            case 2://banner内置样式预览
                startActivity(new Intent(this, BannerStyleActivity.class));
                break;
            case 3://banner指示器设置位置预览
                startActivity(new Intent(this, IndicatorPositionActivity.class));
                break;
            case 4://banner一些自定义样式方法预览
                startActivity(new Intent(this, CustomBannerActivity.class));
                break;
            case 5://banner加载本地图片
                startActivity(new Intent(this, BannerLocalActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, CustomViewPagerActivity.class));
                break;
        }
    }


}
