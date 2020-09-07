package com.atguigu.atguigu_code.butterknife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.atguigu.atguigu_code.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterknifeActivity extends AppCompatActivity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.tv_butterknife)
    TextView tvButterknife;
    @Bind(R.id.cb_butterknife)
    CheckBox cbButterknife;
    @Bind(R.id.bt_butterknife)
    Button btButterknife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 初始化标题
        tvTitlebarName.setText("Butterknife");
        tvButterknife.setText("我好喜欢butterknife");
    }

    @OnClick(R.id.cb_butterknife)
    public void cbButterknife(View view) {
        Toast.makeText(ButterknifeActivity.this, "点击了checkbox", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_butterknife)
    public void btButterknife(View view) {
        Toast.makeText(ButterknifeActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
    }


//    @OnClick({R.id.tv_butterknife, R.id.cb_butterknife})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tv_butterknife:
//                Toast.makeText(ButterknifeActivity.this, "点击了checkbox", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.cb_butterknife:
//                Toast.makeText(ButterknifeActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
}
