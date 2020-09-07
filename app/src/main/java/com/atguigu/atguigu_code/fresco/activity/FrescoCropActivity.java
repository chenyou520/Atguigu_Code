package com.atguigu.atguigu_code.fresco.activity;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoCropActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.sdv_fresco_crop)
    SimpleDraweeView sdvFrescoCrop;
    @Bind(R.id.tv_fresco_explain)
    TextView tvFrescoExplain;
    private GenericDraweeHierarchyBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_crop);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitlebarName.setText("图片的不同裁剪");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({R.id.bt_fresco_center, R.id.bt_fresco_centercrop, R.id.bt_fresco_focuscrop, R.id.bt_fresco_centerinside, R.id.bt_fresco_fitcenter, R.id.bt_fresco_fitstart, R.id.bt_fresco_fitend, R.id.bt_fresco_fitxy, R.id.bt_fresco_none})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_center:// 居中，无缩放
                // 设置描述
                tvFrescoExplain.setText("居中，无缩放");
                // 样式设置
                GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();
                // 图片显示
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_centercrop:// 保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示
                // 设置描述
                tvFrescoExplain.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");
                // 样式设置
                GenericDraweeHierarchy hierarchy1 = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
                // 图片显示
                imageDisplay(hierarchy1);
                break;
            case R.id.bt_fresco_focuscrop:// 同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点
                // 设置描述
                tvFrescoExplain.setText("同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点");
                // 样式设置
                PointF point = new PointF(0, 0);
                GenericDraweeHierarchy hierarchy2 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).setActualImageFocusPoint(point).build();
                // 图片显示
                imageDisplay(hierarchy2);
                break;
            case R.id.bt_fresco_centerinside:// 使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片
                // 设置描述
                tvFrescoExplain.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");
                // 样式设置
                GenericDraweeHierarchy hierarchy3 = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();
                // 图片显示
                imageDisplay(hierarchy3);
                break;
            case R.id.bt_fresco_fitcenter:// 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");
                // 样式设置
                GenericDraweeHierarchy hierarchy4 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
                // 图片显示
                imageDisplay(hierarchy4);
                break;
            case R.id.bt_fresco_fitstart:// 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");
                // 样式设置
                GenericDraweeHierarchy hierarchy5 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();
                // 图片显示
                imageDisplay(hierarchy5);
                break;
            case R.id.bt_fresco_fitend:// 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");
                // 样式设置
                GenericDraweeHierarchy hierarchy6 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();
                // 图片显示
                imageDisplay(hierarchy6);
                break;
            case R.id.bt_fresco_fitxy:// 不保持宽高比，填充满显示边界
                // 设置描述
                tvFrescoExplain.setText("不保持宽高比，填充满显示边界");
                // 样式设置
                GenericDraweeHierarchy hierarchy7 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                // 图片显示
                imageDisplay(hierarchy7);
                break;
            case R.id.bt_fresco_none: // 如要使用title mode显示, 需要设置为none
                // 设置描述
                tvFrescoExplain.setText("如要使用title mode显示, 需要设置为none");
                // 样式设置
                GenericDraweeHierarchy hierarchy8 = builder.setActualImageScaleType(null).build();
                // 图片显示
                imageDisplay(hierarchy8);
                break;
        }
    }

    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
        sdvFrescoCrop.setHierarchy(hierarchy);
        // 加载图片
        Uri uri = Uri.parse("https://bkimg.cdn.bcebos.com/pic/e824b899a9014c08424aed2a087b02087af4f4c8?x-bce-process=image/watermark,g_7,image_d2F0ZXIvYmFpa2UxODA=,xp_5,yp_5");
        sdvFrescoCrop.setImageURI(uri);
    }
}
