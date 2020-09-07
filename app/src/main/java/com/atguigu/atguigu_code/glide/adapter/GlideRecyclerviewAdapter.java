package com.atguigu.atguigu_code.glide.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atguigu.atguigu_code.R;
import com.bumptech.glide.Glide;

public class GlideRecyclerviewAdapter extends RecyclerView.Adapter<GlideRecyclerviewAdapter.ViewHolder> {
    private final Context mContext;
    /**
     * 准备数据
     */
    String[] mDatas = new String[]{
            "http://www.sinaimg.cn/qc/photo_auto/photo/84/35/39698435/39698435_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/44/23/39674423/39674423_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/74/19/39657419/39657419_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/34/09/39653409/39653409_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/53/97/39645397/39645397_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/93/94/39629394/39629394_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/63/79/39616379/39616379_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/53/77/39615377/39615377_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/43/70/39594370/39594370_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/93/58/39579358/39579358_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/23/45/39572345/39572345_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/13/41/39571341/39571341_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/03/29/39550329/39550329_140.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/53/27/39525327/39525327_140.jpg",
    };

    public GlideRecyclerviewAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = View.inflate(mContext, R.layout.item_glide_recyclerview, null);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 获取当前item数据
        // 显示数据
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, mContext.getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, mContext.getResources().getDisplayMetrics());

        Glide.with(mContext)
                .load(mDatas[position])
                .placeholder(R.mipmap.ic_launcher) //占位图
                .error(R.mipmap.ic_launcher)  //出错的占位图
                .override(width, height) //图片显示的分辨率 ，像素值 可以转化为DP再设置
//                .transition(GenericTransitionOptions.with(R.anim.glide_anim))
                .animate(R.anim.glide_anim)
                .centerCrop()
                .fitCenter()
                .into(holder.iv_glide_recyclerview);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_glide_recyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_glide_recyclerview = (ImageView) itemView.findViewById(R.id.iv_glide_recyclerview);
        }
    }
}
