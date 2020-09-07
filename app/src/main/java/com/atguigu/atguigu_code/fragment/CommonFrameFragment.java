package com.atguigu.atguigu_code.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.afinal.AfinalActivity;
import com.atguigu.atguigu_code.android_pulltorefresh.PullToRefreshMainActivity;
import com.atguigu.atguigu_code.banner.activity.BannerMainActivity;
import com.atguigu.atguigu_code.butterknife.ButterknifeActivity;
import com.atguigu.atguigu_code.countdownview.activity.CountdownViewMainActivity;
import com.atguigu.atguigu_code.eventbus.EventBusActivity;
import com.atguigu.atguigu_code.fresco.FrescoActivity;
import com.atguigu.atguigu_code.glide.activity.GlideActivity;
import com.atguigu.atguigu_code.imageloader.activity.ImageLoaderActivity;
import com.atguigu.atguigu_code.jiecaovideoplayer.activity.JieCaoVideoPlayerMainActivity;
import com.atguigu.atguigu_code.json.activity.FastJsonActivity;
import com.atguigu.atguigu_code.json.activity.GsonActivity;
import com.atguigu.atguigu_code.json.activity.NativeJsonPraseActivity;
import com.atguigu.atguigu_code.okhttp.activity.OKHttpActivity;
import com.atguigu.atguigu_code.okhttp.adapter.CommonFrameFragmentAdapter;
import com.atguigu.atguigu_code.okhttp.base.BaseFragment;
import com.atguigu.atguigu_code.opendanmaku.activity.OpenDanmakuMainActivity;
import com.atguigu.atguigu_code.picasso.activity.PicassoActivity;
import com.atguigu.atguigu_code.recyclervview.RecyclerViewActivity;
import com.atguigu.atguigu_code.tablayout.activity.TabLayoutMainActivity;
import com.atguigu.atguigu_code.universalvideoview.UniversalVideoViewActivity;
import com.atguigu.atguigu_code.volley.VolleyActivity;
import com.atguigu.atguigu_code.xutils3.XUtils3MainActivity;

/**
 * 作用：常用框架Fragment
 */
public class CommonFrameFragment extends BaseFragment {
    private static final String TAG = CommonFrameFragment.class.getSimpleName();
    private ListView listview;
    private String[] datas;
    private CommonFrameFragmentAdapter adapter;

    @Override
    public View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        listview = (ListView) view.findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                Toast.makeText(mContext, "data===" + data, Toast.LENGTH_SHORT).show();
                //xian
                if (data.toLowerCase().equals("okhttp")) {
                    // 点击条目跳转到OKHttp页面
                    Intent intent = new Intent(mContext, OKHttpActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("nativejsonprase")) {
                    // 点击条目跳转到手动JSON解析页面
                    Intent intent = new Intent(mContext, NativeJsonPraseActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("gson")) {
                    // 点击条目跳转到Gson解析页面
                    Intent intent = new Intent(mContext, GsonActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("fastjson")) {
                    // 点击条目跳转到FastJson解析页面
                    Intent intent = new Intent(mContext, FastJsonActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("xutils3")) {
                    // 点击条目跳转到xutils3解析页面
                    Intent intent = new Intent(mContext, XUtils3MainActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("afinal")) {
                    // 点击条目跳转到afinal解析页面
                    Intent intent = new Intent(mContext, AfinalActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("volley")) {
                    // 点击条目跳转到VolleyActivity解析页面
                    Intent intent = new Intent(mContext, VolleyActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("eventbus")) {
                    // 点击条目跳转到EventBusActivity解析页面
                    Intent intent = new Intent(mContext, EventBusActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("butterknife")) {
                    // 点击条目跳转到butterknifeActivity解析页面
                    Intent intent = new Intent(mContext, ButterknifeActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("imageloader")) {
                    // 点击条目跳转到Imageloader解析页面
                    Intent intent = new Intent(mContext, ImageLoaderActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("picasso")) {
                    // 点击条目跳转到picasso解析页面
                    Intent intent = new Intent(mContext, PicassoActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("recyclerview")) {
                    // 点击条目跳转到picasso页面
                    Intent intent = new Intent(mContext, RecyclerViewActivity.class);
                    mContext.startActivity(intent);
                } else if (data.toLowerCase().equals("glide")) {
                    // 点击条目跳转到Glide页面
                    Intent intent = new Intent(mContext, GlideActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("fresco")) {
                    // 点击条目跳转到Fresco页面
                    Intent intent = new Intent(mContext, FrescoActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("android-pulltorefresh")) {
                    // 点击条目跳转到PullToRefresh页面
                    Intent intent = new Intent(mContext, PullToRefreshMainActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("universalvideoview")) {
                    // 点击条目跳转到UniversalVideoView页面
                    Intent intent = new Intent(mContext, UniversalVideoViewActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("jiecaovideoplayer")) {
                    // 点击条目跳转到jiecaovideoplayer页面
                    Intent intent = new Intent(mContext, JieCaoVideoPlayerMainActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("banner")) {
                    // 点击条目跳转到Banner页面
                    Intent intent = new Intent(mContext, BannerMainActivity.class);
                    startActivity(intent);
                } else if (data.toLowerCase().equals("countdownview")) {
                    // 点击条目跳转到Banner页面
                    Intent intent = new Intent(mContext, CountdownViewMainActivity.class);
                    startActivity(intent);
                } else if (data.equals("OpenDanmaku弹幕")) {
                    // 点击条目跳转到OpenDanmaku弹幕页面
                    Intent intent = new Intent(mContext, OpenDanmakuMainActivity.class);
                    startActivity(intent);
                } else if(data.equals("TabLayout")) {
                    // 点击条目跳转到TabLayout页面
                    Intent intent = new Intent(mContext, TabLayoutMainActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据被初始化了...");
        //准备数据
        datas = new String[]{"OKHttp", "nativeJsonPrase", "Gson", "FastJson", "xUtils3", "Afinal", "Volley", "eventBus", "Butterknife", "Imageloader", "Picasso", "RecyclerView", "Glide", "Fresco", "Android-PullToRefresh", "UniversalVideoView", "JieCaoVideoPlayer", "Banner", "CountdownView", "OpenDanmaku弹幕","TabLayout", "....."};
        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext, datas);
        listview.setAdapter(adapter);
    }
}
