package com.lifecycle.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.launchmode.life.AActivity;
import com.lifecycle.launchmode.saverestore.SaveActivity;
import com.lifecycle.launchmode.service.ServiceLifeCycleActivity;
import com.lifecycle.launchmode.mode.LaunchModeActivity;
import com.lifecycle.launchmode.startup.StartupOneAct;

//Demo main
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mBtnLifeA;
    private TextView mBtnSave;
    private TextView mBtnLifeS;
    private TextView mBtnLaunch;
    private TextView mBtnStartUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        setTitle(getResources().getString(R.string.app_name_title));

        mBtnLaunch = findViewById(R.id.btn_launch);
        mBtnLifeA = findViewById(R.id.btn_life_a);
        mBtnLifeS = findViewById(R.id.btn_life_s);
        mBtnStartUp = findViewById(R.id.btn_startup_ams);
        mBtnSave = findViewById(R.id.btn_life_save);

        mBtnSave.setOnClickListener(this);
        mBtnLaunch.setOnClickListener(this);
        mBtnLifeA.setOnClickListener(this);
        mBtnLifeS.setOnClickListener(this);
        mBtnStartUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_launch) {
            startActivity(new Intent(MainActivity.this, LaunchModeActivity.class));
        } else if (id == R.id.btn_life_a) {
            startActivity(new Intent(MainActivity.this, AActivity.class));
        } else if (id == R.id.btn_life_s) {
            startActivity(new Intent(MainActivity.this, ServiceLifeCycleActivity.class));
        } else if (id == R.id.btn_startup_ams) {
            startActivity(new Intent(MainActivity.this, StartupOneAct.class));
        } else if (id == R.id.btn_life_save) {
            startActivity(new Intent(MainActivity.this, SaveActivity.class));
        }
    }

}