package com.atguigu.atguigu_code.xutils3.net;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.atguigu_code.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends Activity {

    @ViewInject(R.id.tv_titlebar_name)
    private TextView tv_titlebar_name;

    @ViewInject(R.id.tv_result)
    private TextView textView;

    @ViewInject(R.id.progressbar)
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xutils3_net);
        x.view().inject(this);
        tv_titlebar_name.setText("xUtils3的网络模块");
    }

    @Event(value = {R.id.btn_get_post, R.id.btn_downloadfile, R.id.btn_uploadfile})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_get_post:
                getAndPostNet();
//                Toast.makeText(XUtils3NetActivity.this, "Get和Post请求", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_downloadfile:
                downloadFile();
//                Toast.makeText(XUtils3NetActivity.this, "文件下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_uploadfile:
                uploadFile();
//                Toast.makeText(XUtils3NetActivity.this, "文件上传", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 文件上传
     */
    private void uploadFile() {
        RequestParams params = new RequestParams("http://192.168.1.9:8080/FileUpload/FileUploadServlet");
        //以表单方式上传
        params.setMultipart(true);
        //设置上传文件的路径
        params.addBodyParameter("File",new File(Environment.getExternalStorageDirectory()+"/atguigu/480.mp4"),null,"oppo.mp4");
        x.http().post(params, new Callback.ProgressCallback<File>() {
            /**
             * 当下载成功的时候回调这个方法，并且把下载到哪个路径回传过来
             * @param file
             */
            @Override
            public void onSuccess(File file) {
                Log.e("TAG", "onSuccess==" + file.toString());
                Toast.makeText(XUtils3NetActivity.this, "onSuccess==" + file.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished==");
            }

            @Override
            public void onWaiting() {
                Log.e("TAG", "onWaiting==");
            }

            @Override
            public void onStarted() {
                Log.e("TAG", "onStarted==");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressbar.setMax((int) total);
                progressbar.setProgress((int) current);
                Log.e("TAG", "onLoading==" + current + "/" + total + ",isDownloading==" + isDownloading);

            }
        });
    }

    private void downloadFile() {
        RequestParams params = new RequestParams("http://vfx.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4");
        //设置保存数据
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/atguigu/480.mp4");
        //设置是否可以立即取消下载
        params.setCancelFast(true);
        //设置是否自动根据头信息命名
        params.setAutoRename(false);
        //设置断点续传
        params.setAutoResume(true);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            /**
             * 当下载成功的时候回调这个方法，并且把下载到哪个路径回传过来
             * @param result
             */
            @Override
            public void onSuccess(File result) {
                Log.e("TAG", "onSuccess==" + result.toString());
                Toast.makeText(XUtils3NetActivity.this, "onSuccess==" + result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","onError=="+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","onCancelled=="+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG","onFinished==");
            }

            @Override
            public void onWaiting() {
                Log.e("TAG","onWaiting==");
            }

            @Override
            public void onStarted() {
                Log.e("TAG","onStarted==");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressbar.setMax((int) total);
                progressbar.setProgress((int) current);
                Log.e("TAG", "onLoading=="+current+"/"+total+",isDownloading=="+isDownloading);
            }
        });
    }

    private void getAndPostNet() {
        RequestParams params = new RequestParams("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "xUtis3联网请求成功==" + result);
//                textView.setText("Get请求的结果——————" + result);
                textView.setText("Post请求的结果——————" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "xUtis3联网请求失败==" + ex.getMessage());
                textView.setText("xUtis3联网请求失败==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished==");
            }
        });
    }
}