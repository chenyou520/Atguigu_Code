package com.atguigu.atguigu_code.recyclervview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.atguigu.atguigu_code.Constants;
import com.atguigu.atguigu_code.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewActivity extends Activity {

    @Bind(R.id.tv_titlebar_name)
    TextView tvTitlebarName;
    @Bind(R.id.btn_add)
    Button btnAdd;
    @Bind(R.id.btn_delete)
    Button btnDelete;
    @Bind(R.id.btn_list)
    Button btnList;
    @Bind(R.id.btn_grid)
    Button btnGrid;
    @Bind(R.id.btn_flow)
    Button btnFlow;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    private MyRecyclerViewAdapter adapter;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        initData();
        //设置RecyclerView的适配器
        adapter = new MyRecyclerViewAdapter(RecyclerViewActivity.this, datas);
        recyclerview.setAdapter(adapter);

        //LayoutManager(默认ListView)
        recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, false));

        //添加RecyclerView的分割线
//        recyclerview.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this,DividerItemDecoration.VERTICAL));
        //添加自定义RecyclerView的分割线
        recyclerview.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this,DividerListItemDecoration.VERTICAL_LIST));

        adapter.setOnItemClickListenrt(new MyRecyclerViewAdapter.OnItemClickListenrt() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(RecyclerViewActivity.this, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });
        //设置动画
        recyclerview.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        tvTitlebarName.setText("RecyclerView");
        datas = new ArrayList<>();
        for (int i = 0; i < Constants.IMAGES.length; i++) {
            datas.add("items_" + i);
        }
    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_list, R.id.btn_grid, R.id.btn_flow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                adapter.add(0,"New_Content");
                recyclerview.scrollToPosition(0);
                break;
            case R.id.btn_delete:
                adapter.removeData(0);
                break;
            case R.id.btn_list:
                //设置List类型效果
                recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, false));
                break;
            case R.id.btn_grid:
                //设置Grid类型效果
                recyclerview.setLayoutManager(new GridLayoutManager(RecyclerViewActivity.this, 2, GridLayoutManager.VERTICAL, false));
                break;
            case R.id.btn_flow:
                //设置瀑布流类型效果
                recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }
}
