package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoCircleAndCornerActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.sdv_fresco_circleandcorner)
    SimpleDraweeView sdvFrescoCircleandcorner;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;
    private RoundingParams parames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_circle_and_corner);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("圆形和圆角图片");

        uri = Uri.parse("https://bkimg.cdn.bcebos.com/pic/e824b899a9014c08424aed2a087b02087af4f4c8?x-bce-process=image/watermark,g_7,image_d2F0ZXIvYmFpa2UxODA=,xp_5,yp_5");

        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({R.id.bt_fresco_circle, R.id.bt_fresco_corner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_circle:// 设置圆形图片
                // 设置圆形图片

                parames = RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
            case R.id.bt_fresco_corner: // 设置圆角图片

                parames = RoundingParams.fromCornersRadius(50f);
                parames.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                parames.setBorder(getResources().getColor(android.R.color.holo_red_light), 5);//边框

                GenericDraweeHierarchy hierarchy1 = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy1);
                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
        }
    }
}
