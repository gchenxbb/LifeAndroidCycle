package com.lifecycle.ponent.life;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.ponent.R;

/**
 * 生命周期-Activity-A
 * <p>
 * 启动a：onCreate-->onStart-->onResume
 * 启动b：onPause-->onCreate-->onStart-->onResume-->onStop
 * 关闭b:onPause-->onRestart-->onStart-->onResume-->onStop-->onDestory
 * 关闭a:onPause-->onStop-->onDestory
 */
public class AActivity extends BaseActivity {
    private TextView mBtnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        initView();
        ALog();
    }

    public void initView() {
        mBtnB = findViewById(R.id.btn_life_b);
        mBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this, BActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ALog();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ALog();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ALog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ALog();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ALog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ALog();
    }
}
