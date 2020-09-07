package com.atguigu.atguigu_code.xutils3.annotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.atguigu.atguigu_code.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fragment_xutils3)
public class FragmentXUtils3Activity extends FragmentActivity {

    @ViewInject(R.id.tv_titlebar_name)
    private TextView tv_titlebar_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_xutils3);
        x.view().inject(this);
        tv_titlebar_name.setText("在Fragment中使用注解");

        //1.得到FragmentManger
        FragmentManager fragmentManager = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //3.替换Fragment
        transaction.replace(R.id.fl_content,new DemoFragment());
        //4.提交
        transaction.commit();
    }
}
