package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoResizeActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.sdv_fresco_resize)
    SimpleDraweeView sdvFrescoResize;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_resize);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("图片缩放和旋转");
        // 图片地址
        uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");
    }

    @OnClick({R.id.bt_fresco_resize, R.id.bt_fresco_rotate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_resize:// 修内存中改图片大小

                // 图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(new ResizeOptions(50, 50))
                        .build();
                // 控制图片的加载
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoResize.getController())
                        .setImageRequest(request)
                        .build();
                sdvFrescoResize.setController(controller);
                break;
            case R.id.bt_fresco_rotate:// 旋转图片
                // 图片的请求
                ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setAutoRotateEnabled(true)
                        .build();
                // 控制图片的加载
                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoResize.getController())
                        .setImageRequest(request1)
                        .build();
                sdvFrescoResize.setController(controller1);
                break;
        }
    }
}
