package com.atguigu.atguigu_code.activity;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.okhttp.base.BaseFragment;
import com.atguigu.atguigu_code.fragment.CommonFrameFragment;
import com.atguigu.atguigu_code.fragment.CustomFragment;
import com.atguigu.atguigu_code.fragment.OtherFragment;
import com.atguigu.atguigu_code.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_bottom_tag;
    private List<BaseFragment> baseFragments;
    /**
     * 选中的Fragment的对应的位置
     */
    private int position;
    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rg_bottom_tag = (RadioGroup) findViewById(R.id.rg_bottom_tag);
    }

    private void initFragment() {
        baseFragments = new ArrayList<>();
        baseFragments.add(new CommonFrameFragment());//常用框架
        baseFragments.add(new ThirdPartyFragment());//第三方
        baseFragments.add(new CustomFragment());//自定义
        baseFragments.add(new OtherFragment());//其他
    }


    private void setListener() {
        rg_bottom_tag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        rg_bottom_tag.check(R.id.rb_common_frame);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_common_frame://常用框架
                    position = 0;
                    break;
                case R.id.rb_thirdparty://第三方
                    position = 1;
                    break;
                case R.id.rb_custom://自定义
                    position = 2;
                    break;
                case R.id.rb_other://其他
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragment fragment = getFragment();
            //替换
            switchFrament(mContent, fragment);
        }
    }


    /**
     * @param preFrament 刚显示的Fragment,马上就要被隐藏了
     * @param fragment   马上要切换到的Fragment，一会要显示
     */
    private void switchFrament(Fragment preFrament, BaseFragment fragment) {
        if (preFrament != fragment) {
            mContent = fragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //切换
            //判断fragment有没有被添加过
            if (!fragment.isAdded()) {
                //fragment没有被添加
                //preFrament隐藏
                if (preFrament != null) {
                    transaction.hide(preFrament);
                }
                //添加fragment
                if (fragment != null) {
                    transaction.add(R.id.fl_content, fragment).commit();
                }
            } else {
                //fragment已经被添加
                //preFrament隐藏
                if (preFrament != null) {
                    transaction.hide(preFrament);
                }
                if (fragment != null) {
                    transaction.show(fragment).commit();
                }
            }
        }
    }

    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragment getFragment() {
        if (baseFragments != null && baseFragments.size() > 0) {
            BaseFragment baseFragment = baseFragments.get(position);
            return baseFragment;
        }
        return null;
    }
}
