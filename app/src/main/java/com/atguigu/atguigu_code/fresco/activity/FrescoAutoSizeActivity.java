package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoAutoSizeActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.ll_fresco)
    LinearLayout llFresco;
    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_auto_size);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("动态展示图片");
        simpleDraweeView = new SimpleDraweeView(this);
        // 设置宽高比
        simpleDraweeView.setAspectRatio(1.0f);
    }

    @OnClick(R.id.bt_fresco_loadsmall)
    public void onViewClicked() {
        // 图片的地址
        Uri uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");
        // 图片的请求
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).build();
        // 加载图片的控制
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(simpleDraweeView.getController())
                .setImageRequest(request)
                .build();
        // 加载图片的控制
        simpleDraweeView.setController(controller);
        // 添加View到线性布局中
        llFresco.addView(simpleDraweeView);
    }
}
