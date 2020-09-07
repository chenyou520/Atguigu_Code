package com.atguigu.atguigu_code.fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.fresco.activity.FrescoAutoSizeActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoCircleAndCornerActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoCropActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoGifAcitivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoJpegActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoListenerActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoModifyActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoMultiActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoResizeActivity;
import com.atguigu.atguigu_code.fresco.activity.FrescoSpimgActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("Fresco");
    }

    @OnClick({R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg, R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize, R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_spimg: // 带进度条的图片
                Intent intent = new Intent(FrescoActivity.this, FrescoSpimgActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_fresco_crop: // 图片的不同裁剪
                Intent intent1 = new Intent(FrescoActivity.this, FrescoCropActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_fresco_circleAndCorner:// 圆形和圆角图片
                Intent intent2 = new Intent(FrescoActivity.this, FrescoCircleAndCornerActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_fresco_jpeg:// 渐进式展示图片
                Intent intent3 = new Intent(FrescoActivity.this, FrescoJpegActivity.class);
                startActivity(intent3);
                break;
            case R.id.bt_fresco_gif: // GIF动画图片
                Intent intent4 = new Intent(FrescoActivity.this, FrescoGifAcitivity.class);
                startActivity(intent4);
                break;
            case R.id.bt_fresco_multi:// 多图请求及图片复用
                Intent intent5 = new Intent(FrescoActivity.this, FrescoMultiActivity.class);
                startActivity(intent5);
                break;
            case R.id.bt_fresco_listener:// 图片加载监听
                Intent intent6 = new Intent(FrescoActivity.this, FrescoListenerActivity.class);
                startActivity(intent6);
                break;
            case R.id.bt_fresco_resize:// 图片修改和旋转
                Intent intent7 = new Intent(FrescoActivity.this, FrescoResizeActivity.class);
                startActivity(intent7);
                break;
            case R.id.bt_fresco_modifyImg:// 修改图片
                Intent intent8 = new Intent(FrescoActivity.this, FrescoModifyActivity.class);
                startActivity(intent8);
                break;
            case R.id.bt_fresco_autoSizeImg:// 动态展示图片
                Intent intent9 = new Intent(FrescoActivity.this, FrescoAutoSizeActivity.class);
                startActivity(intent9);
                break;
        }
    }
}
