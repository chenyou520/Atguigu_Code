package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoMultiActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.sdv_fresco_multi)
    SimpleDraweeView sdvFrescoMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_multi);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("多图请求及图片复用");
    }

    @OnClick({R.id.bt_fresco_multiImg, R.id.bt_fresco_thumbnailImg, R.id.bt_fresco_multiplexImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_multiImg:// 先显示低分辨率的图，然后是高分辨率的图
                // 图片地址
                Uri lowUri = Uri.parse("http://cdn.duitang.com/uploads/item/201303/12/20130312021353_45Qix.jpeg");
                Uri highUri = Uri.parse("https://bkimg.cdn.bcebos.com/pic/e824b899a9014c08424aed2a087b02087af4f4c8?x-bce-process=image/watermark,g_7,image_d2F0ZXIvYmFpa2UxODA=,xp_5,yp_5");
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setLowResImageRequest(ImageRequest.fromUri(lowUri))
                        .setImageRequest(ImageRequest.fromUri(highUri))
                        .build();
                sdvFrescoMulti.setController(controller);
                break;
            case R.id.bt_fresco_thumbnailImg:// 本地缩略图预览
                // 图片地址
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() +"/46.jpg"));
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setLocalThumbnailPreviewsEnabled(true)
                        .build();

                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .build();
                sdvFrescoMulti.setController(controller1);
                break;
            case R.id.bt_fresco_multiplexImg:// 本地图片复用
                //本地图片的复用
                //在请求之前，还会去内存中请求一次图片，没有才会先去本地，最后去网络uri
                //本地准备复用图片的uri  如果本地这个图片不存在，会自动去加载下一个uri

                // 请求加载图片
                Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory()+"/47.jpg"));
                //图片的网络uri
                Uri uri2 = Uri.parse("http://cdn.duitang.com/uploads/item/201303/12/20130312021353_45Qix.jpeg");
                ImageRequest request1 = ImageRequest.fromUri(uri1);
                ImageRequest request2 = ImageRequest.fromUri(uri2);
                ImageRequest[] requests = {request1, request2};

                DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                        .setFirstAvailableImageRequests(requests)
                        .setOldController(sdvFrescoMulti.getController())
                        .build();
                sdvFrescoMulti.setController(controller2);
                break;
        }
    }
}
