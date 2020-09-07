package com.atguigu.atguigu_code.glide.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideBaseActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.tv_glide_1)
    TextView tvGlide1;
    @Bind(R.id.iv_glide_1)
    ImageView ivGlide1;
    @Bind(R.id.tv_glide_2)
    TextView tvGlide2;
    @Bind(R.id.iv_glide_2)
    ImageView ivGlide2;
    @Bind(R.id.tv_glide_3)
    TextView tvGlide3;
    @Bind(R.id.iv_glide_3)
    ImageView ivGlide3;
    @Bind(R.id.tv_glide_4)
    TextView tvGlide4;
    @Bind(R.id.iv_glide_4)
    ImageView ivGlide4;
    @Bind(R.id.tv_glide_5)
    TextView tvGlide5;
    @Bind(R.id.iv_glide_5)
    ImageView ivGlide5;
    @Bind(R.id.tv_glide_6)
    TextView tvGlide6;
    @Bind(R.id.iv_glide_6)
    ImageView ivGlide6;
    @Bind(R.id.tv_glide_7)
    TextView tvGlide7;
    @Bind(R.id.iv_glide_7)
    ImageView ivGlide7;
    @Bind(R.id.tv_glide_8)
    TextView tvGlide8;
    @Bind(R.id.iv_glide_8)
    ImageView ivGlide8;
    @Bind(R.id.tv_glide_9)
    TextView tvGlide9;
    @Bind(R.id.iv_glide_9)
    ImageView ivGlide9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_base);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("Glide基本使用");

        //（1）加载网络图片
        tvGlide1.setText("（1）加载网络图片");
        Glide.with(this).load("http://img1.imgtn.bdimg.com/it/u=2615772929,948758168&fm=21&gp=0.jpg").into(ivGlide1);

        //（2）加载资源图片
        tvGlide2.setText("（2）加载资源图片");
        Glide.with(this).load(R.drawable.atguigu_logo).into(ivGlide2);

        //（3）加载本地图片
        tvGlide3.setText("（3）加载本地图片");
        String path = Environment.getExternalStorageDirectory() + "/46.jpg";
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this).load(uri).into(ivGlide3);

        // （4）加载网络gif
        tvGlide4.setText("（4）加载网络gif");
        String gifUrl = "http://b.hiphotos.baidu.com/zhidao/pic/item/faedab64034f78f066abccc57b310a55b3191c67.jpg";
        Glide.with(this).load(gifUrl).placeholder(R.mipmap.ic_launcher).into(ivGlide4);

        // （5）加载资源gif
        tvGlide5.setText("（5）加载资源gif");
        Glide.with(this).load(R.drawable.loading).placeholder(R.mipmap.ic_launcher).into(ivGlide5);

        //（6）加载本地gif
        tvGlide6.setText("（6）加载本地gif");
        String gifpath = Environment.getExternalStorageDirectory() + "/46.jpg";
        File giffile = new File(gifpath);
        Uri gifuri = Uri.fromFile(giffile);
        Glide.with(this).load(gifuri).placeholder(R.mipmap.ic_launcher).into(ivGlide6);

        //（7）加载本地小视频和快照
        tvGlide7.setText("（7）加载本地小视频和快照");
        String videopath = Environment.getExternalStorageDirectory() + "/480.mp4";
        File videofile = new File(videopath);
        Glide.with(this).load(videofile).placeholder(R.mipmap.ic_launcher).into(ivGlide7);

        //（8）设置缩略图比例,然后，先加载缩略图，再加载原图
        tvGlide8.setText("（8）设置缩略图比例,然后，先加载缩略图，再加载原图");
        String urlpath = Environment.getExternalStorageDirectory() + "/46.jpg";
        File urlfile = new File(path);
        Glide.with(this).load(urlfile).thumbnail(0.1f).centerCrop().placeholder(R.mipmap.ic_launcher).into(ivGlide8);


        //（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图
        tvGlide9.setText("（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图");
        DrawableRequestBuilder drawableTypeRequest = Glide.with(this).load(new File(urlpath));
//        RequestBuilder<Drawable> drawableTypeRequest= Glide.with(this).load(new File(urlpath));
        Glide.with(this).load(Uri.fromFile(videofile)).thumbnail(drawableTypeRequest).centerCrop().placeholder(R.mipmap.ic_launcher).into(ivGlide9);
    }
}
