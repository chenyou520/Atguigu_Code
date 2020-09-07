package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoGifAcitivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.sdv_fresco_gif)
    SimpleDraweeView sdvFrescoGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_gif_acitivity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("Gif动画图片");
    }

    @OnClick({R.id.bt_fresco_askImg, R.id.bt_fresco_stopAnim, R.id.bt_fresco_startAnim})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.bt_fresco_askImg://请求gif图片
                Uri uri = Uri.parse("https://imgsa.baidu.com/forum/pic/item/f5958bd4b31c8701185d076f277f9e2f0508ffb3.jpg?v=tbs");
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false)
                        .setOldController(sdvFrescoGif.getController())
                        .build();
                sdvFrescoGif.setController(controller);
                break;
            case R.id.bt_fresco_stopAnim://动画停止
                Animatable animatable = sdvFrescoGif.getController().getAnimatable();
                if (animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }
                break;
            case R.id.bt_fresco_startAnim://动画开始
                Animatable animatable1 = sdvFrescoGif.getController().getAnimatable();
                if (animatable1 != null && !animatable1.isRunning()) {
                    animatable1.start();
                }
                break;
        }
    }
}
