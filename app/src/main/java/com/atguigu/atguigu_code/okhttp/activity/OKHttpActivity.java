package com.atguigu.atguigu_code.okhttp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.atguigu_code.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = OKHttpActivity.class.getSimpleName();
    private static final int GET = 1;
    private static final int POST = 2;
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Button btnOkhttpGet;
    private Button btnOkhttpPost;
    private Button btnOkhttputilsGet;
    private Button btnOkhttputilsPost;
    private Button btnDownloadfile;
    private Button btnUploadfile;
    private Button btnImage;
    private Button btnImageList;
    private Button btnClear;
    private TextView tvContent;
    private ProgressBar progressBar;
    private ImageView ivIcon;
    private TextView tvTitlebarName;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET:
                    tvContent.setText((String) msg.obj);
                    break;
                case POST:
                    tvContent.setText((String) msg.obj);
                    break;
            }
        }
    };

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2020-03-26 11:04:14 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        btnOkhttpGet = (Button)findViewById( R.id.btn_okhttp_get );
        btnOkhttpPost = (Button)findViewById( R.id.btn_okhttp_post );
        btnOkhttputilsGet = (Button)findViewById( R.id.btn_okhttputils_get );
        btnOkhttputilsPost = (Button)findViewById( R.id.btn_okhttputils_post );
        btnDownloadfile = (Button)findViewById( R.id.btn_downloadfile );
        btnUploadfile = (Button)findViewById( R.id.btn_uploadfile );
        btnImage = (Button)findViewById( R.id.btn_image );
        btnImageList = (Button)findViewById( R.id.btn_image_list );
        btnClear = (Button)findViewById( R.id.btn_clear );
        tvContent = (TextView)findViewById( R.id.tv_content );
        progressBar = (ProgressBar)findViewById( R.id.progressBar );
        ivIcon = (ImageView)findViewById( R.id.iv_icon );
        tvTitlebarName = (TextView)findViewById(R.id.tv_titlebar_name);

        btnOkhttpGet.setOnClickListener( this );
        btnOkhttpPost.setOnClickListener( this );
        btnOkhttputilsGet.setOnClickListener( this );
        btnOkhttputilsPost.setOnClickListener( this );
        btnDownloadfile.setOnClickListener( this );
        btnUploadfile.setOnClickListener( this );
        btnImage.setOnClickListener( this );
        btnImageList.setOnClickListener( this );
        btnClear.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-03-26 11:04:14 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnOkhttpGet ) {
            // Handle clicks for btnOkhttpGet
            tvContent.setText("");
            getDataFromGet();
        } else if ( v == btnOkhttpPost ) {
            // Handle clicks for btnOkhttpPost
            tvContent.setText("");
            getDataFromPost();
        } else if ( v == btnOkhttputilsGet ) {
            // Handle clicks for btnOkhttputilsGet
            tvContent.setText("");
            getDataGetByOkhttpUtils();
        } else if ( v == btnOkhttputilsPost ) {
            // Handle clicks for btnOkhttputilsPost
            tvContent.setText("");
            getDataPostByOkhttpUtils();
        } else if ( v == btnDownloadfile ) {//下载文件
            // Handle clicks for btnDownloadfile
            downloadFile();
        } else if ( v == btnUploadfile ) {//文件上传
            // Handle clicks for btnUploadfile
            multiFileUpload();
        } else if ( v == btnImage ) {//请求单张图片
            // Handle clicks for btnImage
            getImage();
        } else if ( v == btnImageList ) {//请求列表中的图片
            // Handle clicks for btnImageList
            Intent intent = new Intent(OKHttpActivity.this, OKHttpListActivity.class);
            startActivity(intent);
        } else if ( v == btnClear ) {
            // Handle clicks for btnClear
            tvContent.setText("请求内容显示");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        findViews();
        tvTitlebarName.setText("OKHttp");
    }

    /**
     * 使用原生okhttp3的get请求网络数据
     */
    private void getDataFromGet() {
        new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                super.run();
                try {
                    String result = get("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    Log.e("TAG", result);
                    //使用Message.obtain()的好处是Message对象可以重复使用,可以免除一直new Message对象造成无谓的内存压力(不断新建销毁对象),
                    Message message = Message.obtain();
                    message.what = GET;
                    message.obj = result;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    /**
     * 使用原生okhttp3的post请求网络数据
     */
    private void getDataFromPost() {
        new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                super.run();
                try {
                    String result = post("http://api.m.mtime.cn/PageSubArea/TrailerList.api","");
                    Log.e("TAG", result);
                    //使用Message.obtain()的好处是Message对象可以重复使用,可以免除一直new Message对象造成无谓的内存压力(不断新建销毁对象),
                    Message message = Message.obtain();
                    message.what = POST;
                    message.obj = result;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    /**
     * 原生okhttp3的get请求网络数据
     *
     * @param url 网络连接
     * @return
     * @throws IOException
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    /**
     * 原生okhttp3的post请求网络数据
     *
     * @param url 网络连接
     * @param json
     * @return
     * @throws IOException
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 使用okhttp-utils的get请求网络文本数据
     */
    public void getDataGetByOkhttpUtils() {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
//        url = "http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    /**
     * 使用okhttp-utils的post请求网络文本数据
     */
    public void getDataPostByOkhttpUtils() {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
//        url = "http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .post()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    /**
     * 使用okhttp-utils下载大文件
     */
    public void downloadFile() {
//        String url = "https://github.com/hongyangAndroid/okhttp-utils/blob/master/okhttputils-2_4_1.jar?raw=true";
        String url = "http://vfx.mtime.cn/Video/2016/07/24/mp4/160724055620533327_480.mp4";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "480.mp4")//
                {

                    @Override
                    public void onBefore(Request request, int id) {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        progressBar.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }

    /**
     * 使用okhttp-utils多文件上传
     */
    public void multiFileUpload() {
        String mBaseUrl = "http://192.168.0.103:8080/FileUpload/FileUploadServlet";
        File file = new File(Environment.getExternalStorageDirectory(), "46.jpg");
        File file2 = new File(Environment.getExternalStorageDirectory(), "师士传说.txt");
        if (!file.exists()) {
            Toast.makeText(OKHttpActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", "张鸿洋");
        params.put("password", "123");

        String url = mBaseUrl;
        OkHttpUtils.post()//
                .addFile("mFile", "46.jpg", file)//
                .addFile("mFile", "师士传说.txt", file2)//
                .url(url)
                .params(params)//
                .build()//
                .execute(new MyStringCallback());
    }

    /**
     * 使用okhttp-utils获取图片
     */
    public void getImage() {
        tvContent.setText("");
        String url = "http://images.csdn.net/20150817/1.jpg";
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        tvContent.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id) {
                        Log.e("TAG", "onResponse：complete");
                        ivIcon.setImageBitmap(bitmap);
                    }
                });
    }

    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            tvContent.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            tvContent.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    Toast.makeText(OKHttpActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OKHttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
            progressBar.setProgress((int) (100 * progress));
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
