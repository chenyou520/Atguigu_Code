package com.atguigu.atguigu_code.jiecaovideoplayer.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.atguigu.atguigu_code.R;
import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Nathen on 16/10/13.
 */

public class WebViewActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("AboutWebView");
        setContentView(R.layout.activity_webview);
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JCCallBack(), "jcvd");
        mWebView.loadUrl("file:///android_asset/jcvd.html");
    }

    public class JCCallBack {

        @JavascriptInterface
        public void adViewJieCaoVideoPlayer(final int width, final int height, final int top, final int left, final int index) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (index == 0) {
                        JCVideoPlayerStandard webVieo = new JCVideoPlayerStandard(WebViewActivity.this);
                        webVieo.setUp("http://vfx.mtime.cn/Video/2019/06/15/mp4/190615103827358781.mp4",
                                JCVideoPlayer.SCREEN_LAYOUT_LIST, "迪士尼《狮子王》中国定档预告片");
                        Picasso.with(WebViewActivity.this)
                                .load("http://img5.mtime.cn/mg/2019/06/15/103753.65527244_120X90X4.jpg")
                                .into(webVieo.thumbImageView);
                        ViewGroup.LayoutParams ll = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(ll);
                        layoutParams.y = JCUtils.dip2px(WebViewActivity.this, top);
                        layoutParams.x = JCUtils.dip2px(WebViewActivity.this, left);
                        layoutParams.height = JCUtils.dip2px(WebViewActivity.this, height);
                        layoutParams.width = JCUtils.dip2px(WebViewActivity.this, width);
                        mWebView.addView(webVieo, layoutParams);
                    } else {
                        JCVideoPlayerStandard webVieo = new JCVideoPlayerStandard(WebViewActivity.this);
                        webVieo.setUp("http://vfx.mtime.cn/Video/2019/06/14/mp4/190614072243066963.mp4",
                                JCVideoPlayer.SCREEN_LAYOUT_LIST, "《闪灵》续集《睡眠医生》中字预告");
                        Picasso.with(WebViewActivity.this)
                                .load("http://img5.mtime.cn/mg/2019/06/14/072221.53413572_120X90X4.jpg")
                                .into(webVieo.thumbImageView);
                        ViewGroup.LayoutParams ll = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(ll);
                        layoutParams.y = JCUtils.dip2px(WebViewActivity.this, top);
                        layoutParams.x = JCUtils.dip2px(WebViewActivity.this, left);
                        layoutParams.height = JCUtils.dip2px(WebViewActivity.this, height);
                        layoutParams.width = JCUtils.dip2px(WebViewActivity.this, width);
                        mWebView.addView(webVieo, layoutParams);
                    }

                }
            });

        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
