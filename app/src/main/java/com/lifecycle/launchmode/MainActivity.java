package com.lifecycle.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.app.R;

//demo main
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mBtnLifeA;
    private TextView mBtnLifeS;
    private TextView mBtnLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        mBtnLaunch = findViewById(R.id.btn_launch);
        mBtnLifeA = findViewById(R.id.btn_life_a);
        mBtnLifeS = findViewById(R.id.btn_life_s);

        mBtnLaunch.setOnClickListener(this);
        mBtnLifeA.setOnClickListener(this);
        mBtnLifeS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_launch) {
        } else if (id == R.id.btn_life_a) {
            startActivity(new Intent(MainActivity.this, AActivity.class));
        } else if (id == R.id.btn_life_s) {
            startActivity(new Intent(MainActivity.this, ServiceActivity.class));
        }
    }
}
