package com.atguigu.atguigu_code.picasso.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.atguigu_code.Constants;
import com.atguigu.atguigu_code.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoListviewAdapter extends BaseAdapter {
    private final Context mContext;

    public PicassoListviewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_picasso_listview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 名称
        viewHolder.tvPicassoName.setText("item"+(position+1));
        // 加载图片
        Picasso.with(mContext)
                .load(Constants.IMAGES[position])
                .placeholder(R.drawable.atguigu_logo)
                .error(R.drawable.atguigu_logo)
                .into(viewHolder.ivPicassoItem);
        return convertView;
    }

    static
    class ViewHolder {
        @Bind(R.id.iv_picasso_item)
        ImageView ivPicassoItem;
        @Bind(R.id.tv_picasso_name)
        TextView tvPicassoName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
