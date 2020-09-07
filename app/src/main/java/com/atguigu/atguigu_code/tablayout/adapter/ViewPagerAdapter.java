package com.atguigu.atguigu_code.tablayout.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.atguigu.atguigu_code.tablayout.fragment.MyFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private final ArrayList<MyFragment> fragments;

    public ViewPagerAdapter(FragmentManager ft, ArrayList<MyFragment> fragments) {
        super(ft);
        this.fragments = fragments;
    }

    /**
     * 根据位置返回对应的Fragment
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * 得到页面的标题
     * @param position
     * @return
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
