package com.atguigu.atguigu_code.imageloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageloaderListviewAdapter extends BaseAdapter {

    private final Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.atguigu_logo)          // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.atguigu_logo)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.atguigu_logo)       // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
            .displayer(new RoundedBitmapDisplayer(10))  // 设置成圆角图片
            .build();                                   // 创建配置过得DisplayImageOption对象;

    public ImageloaderListviewAdapter(Context context) {
        mContext = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.IMAGES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取或创建viewhoder
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_imageloader_listview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 获取当前item数据

        // 显示数据
        viewHolder.tvImageloaderName.setText("item" + (position + 1));
        imageLoader.displayImage(Constants.IMAGES[position], viewHolder.ivImageloaderListview, options);

        return convertView;
    }

    static
    class ViewHolder {
        @Bind(R.id.iv_imageloader_listview)
        ImageView ivImageloaderListview;
        @Bind(R.id.tv_imageloader_name)
        TextView tvImageloaderName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
