package com.atguigu.atguigu_code.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.atguigu.atguigu_code.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends Activity {

    private TextView tv_titlebar_name;
    private Button bt_volley_get;
    private Button bt_volley_post;
    private Button bt_volley_getjson;
    private Button bt_volley_imagerequest;
    private Button bt_volley_imageloader;
    private Button bt_volley_networkimageview;
    private ImageView iv_volley_result;
    private NetworkImageView iv_volley_networkimagview;
    private TextView tv_volley_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        initView();

        initData();

        initListener();
    }

    private void initView() {
        tv_titlebar_name = (TextView) findViewById(R.id.tv_titlebar_name);
        bt_volley_get = (Button) findViewById(R.id.bt_volley_get);
        bt_volley_post = (Button) findViewById(R.id.bt_volley_post);
        bt_volley_getjson = (Button) findViewById(R.id.bt_volley_getjson);
        bt_volley_imagerequest = (Button) findViewById(R.id.bt_volley_imagerequest);
        bt_volley_imageloader = (Button) findViewById(R.id.bt_volley_imageloader);
        bt_volley_networkimageview = (Button) findViewById(R.id.bt_volley_networkimageview);
        iv_volley_result = (ImageView) findViewById(R.id.iv_volley_result);
        iv_volley_networkimagview = (NetworkImageView) findViewById(R.id.iv_volley_networkimagview);
        tv_volley_result = (TextView) findViewById(R.id.tv_volley_result);
    }


    private void initData() {
        tv_titlebar_name.setText("Volley");
    }

    private void initListener() {
        // get请求
        bt_volley_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 创建一个请求队列
                RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
                // 2 创建一个请求
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {// 正确接收数据回调
                        tv_volley_result.setText(s);
                    }
                }, new Response.ErrorListener() {// 发生异常后的监听回调
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_volley_result.setText("加载失败" + volleyError);
                    }
                });

                // 3 将创建的请求添加到请求队列中
                queue.add(request);
            }
        });

        // post请求
        bt_volley_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 创建一个请求队列
                RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
                // 2 创建一个请求
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tv_volley_result.setText(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_volley_result.setText("请求失败" + volleyError);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("value1","param1");
                        return map;
                    }
                };
                // 3 将创建的请求添加到请求队列中
                queue.add(request);
            }
        });

        // 获取json数据
        bt_volley_getjson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 创建一个请求队列
                RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
                // 2 创建一个请求
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        tv_volley_result.setText(jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_volley_result.setText("请求失败" + volleyError);
                    }
                });
                // 3 将创建的请求添加到请求队列中
                queue.add(request);
            }
        });

        // imagerequest加载图片
        bt_volley_imagerequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 创建一个请求队列
                RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
                // 2 创建一个请求
                String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
                ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        // 正确接收到图片
                        iv_volley_result.setVisibility(View.VISIBLE);
                        iv_volley_result.setImageBitmap(bitmap);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        iv_volley_result.setImageResource(R.drawable.atguigu_logo);
                    }
                });

                // 3 将创建的请求添加到请求队列中
                queue.add(request);
            }
        });

        // imageloader加载图片
        bt_volley_imageloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 创建一个请求队列
                RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);

                // 2 创建一个imageloader
                ImageLoader imageLoader = new ImageLoader(queue,new BitmapCache());

                // 加载图片
                String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
                iv_volley_result.setVisibility(View.VISIBLE);
                ImageLoader.ImageListener imageListener =  imageLoader.getImageListener(iv_volley_result, R.drawable.atguigu_logo, R.drawable.atguigu_logo);;
                imageLoader.get(url,imageListener);
            }
        });

        // networkimageview加载图片
        bt_volley_networkimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 让控件显示
                iv_volley_networkimagview.setVisibility(View.VISIBLE);

                // 创建一个请求队列
                RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
                // 2 创建一个imageloader
                ImageLoader imageLoader = new ImageLoader(requestQueue,new BitmapCache());

                // 默认图片和异常图片设置
                iv_volley_networkimagview.setDefaultImageResId(R.drawable.video_default);
                iv_volley_networkimagview.setErrorImageResId(R.drawable.atguigu_logo);

                // 加载图片
                String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
                iv_volley_networkimagview.setImageUrl(url,imageLoader);
            }
        });
    }
}
