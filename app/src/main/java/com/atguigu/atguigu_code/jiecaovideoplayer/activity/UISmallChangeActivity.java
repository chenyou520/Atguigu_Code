package com.atguigu.atguigu_code.jiecaovideoplayer.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.jiecaovideoplayer.customview.JCVideoPlayerStandardAutoComplete;
import com.atguigu.atguigu_code.jiecaovideoplayer.customview.JCVideoPlayerStandardShowShareButtonAfterFullscreen;
import com.atguigu.atguigu_code.jiecaovideoplayer.customview.JCVideoPlayerStandardShowTextureViewAfterAutoComplete;
import com.atguigu.atguigu_code.jiecaovideoplayer.customview.JCVideoPlayerStandardShowTitleAfterFullscreen;
import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Nathen on 16/7/31.
 */
public class UISmallChangeActivity extends AppCompatActivity {
    JCVideoPlayerStandardShowShareButtonAfterFullscreen jcVideoPlayerStandardWithShareButton;
    JCVideoPlayerStandardShowTitleAfterFullscreen jcVideoPlayerStandardShowTitleAfterFullscreen;
    JCVideoPlayerStandardShowTextureViewAfterAutoComplete jcVideoPlayerStandardShowTextureViewAfterAutoComplete;
    JCVideoPlayerStandardAutoComplete jcVideoPlayerStandardAutoComplete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("SmallChangeUI");
        setContentView(R.layout.activity_ui_small_change);

        jcVideoPlayerStandardWithShareButton = (JCVideoPlayerStandardShowShareButtonAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_with_share_button);
        jcVideoPlayerStandardWithShareButton.setUp("http://vfx.mtime.cn/Video/2019/06/14/mp4/190614090849863188.mp4", JCVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "汤唯雷佳音《吹哨人》定档预告");
        Picasso.with(this)
                .load("http://img5.mtime.cn/mg/2019/06/14/090801.15262949_120X90X4.jpg")
                .into(jcVideoPlayerStandardWithShareButton.thumbImageView);


        jcVideoPlayerStandardShowTitleAfterFullscreen = (JCVideoPlayerStandardShowTitleAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_show_title_after_fullscreen);
        jcVideoPlayerStandardShowTitleAfterFullscreen.setUp("http://vfx.mtime.cn/Video/2019/06/12/mp4/190612205428644400.mp4", JCVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "中国科幻《上海堡垒》新预告外星母舰入侵");
        Picasso.with(this)
                .load("http://img5.mtime.cn/mg/2019/06/12/205329.35792320_120X90X4.jpg")
                .into(jcVideoPlayerStandardShowTitleAfterFullscreen.thumbImageView);

        jcVideoPlayerStandardShowTextureViewAfterAutoComplete = (JCVideoPlayerStandardShowTextureViewAfterAutoComplete) findViewById(R.id.custom_videoplayer_standard_show_textureview_aoto_complete);
        jcVideoPlayerStandardShowTextureViewAfterAutoComplete.setUp("http://vfx.mtime.cn/Video/2019/06/11/mp4/190611221730282660.mp4", JCVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "魔幻再起！《冰雪奇缘2》曝正式预告");
        Picasso.with(this)
                .load("http://img5.mtime.cn/mg/2019/06/11/202131.80341046_120X90X4.jpg")
                .into(jcVideoPlayerStandardShowTextureViewAfterAutoComplete.thumbImageView);

        jcVideoPlayerStandardAutoComplete = (JCVideoPlayerStandardAutoComplete) findViewById(R.id.custom_videoplayer_standard_aoto_complete);
        jcVideoPlayerStandardAutoComplete.setUp("http://vfx.mtime.cn/Video/2019/06/11/mp4/190611000340681831.mp4", JCVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "不是喜剧！邓超导演《银河补习班》发新预告");
        Picasso.with(this)
                .load("http://img5.mtime.cn/mg/2019/06/11/000307.58997745_120X90X4.jpg")
                .into(jcVideoPlayerStandardAutoComplete.thumbImageView);
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
