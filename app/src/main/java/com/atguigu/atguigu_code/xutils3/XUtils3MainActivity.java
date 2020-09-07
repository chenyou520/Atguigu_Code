package com.atguigu.atguigu_code.xutils3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.atguigu_code.R;
import com.atguigu.atguigu_code.xutils3.annotation.FragmentXUtils3Activity;
import com.atguigu.atguigu_code.xutils3.net.XUtils3NetActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_main)
public class XUtils3MainActivity extends Activity {

    @ViewInject(R.id.tv_titlebar_name)
    private TextView tv_titlebar_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xutils3_main);
        x.view().inject(this);

        //设置标题
        tv_titlebar_name.setText("xUtils3的使用");
    }

    @Event(value = {R.id.btn_annotation,R.id.btn_net,R.id.btn_image,R.id.btn_image_list})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_annotation:
                Toast.makeText(XUtils3MainActivity.this, "注解模块被点击了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(XUtils3MainActivity.this, FragmentXUtils3Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                Toast.makeText(XUtils3MainActivity.this, "网络模块被点击了", Toast.LENGTH_SHORT).show();
                intent = new Intent(XUtils3MainActivity.this, XUtils3NetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_image:
                Toast.makeText(XUtils3MainActivity.this, "加载单张图片被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:
                Toast.makeText(XUtils3MainActivity.this, "加载列表图片被点击了", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
