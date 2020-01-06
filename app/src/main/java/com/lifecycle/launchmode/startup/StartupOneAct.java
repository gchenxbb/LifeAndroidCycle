package com.lifecycle.launchmode.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lifecycle.launchmode.R;

public class StartupOneAct extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_one);
        findViewById(R.id.btn_startup_one).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_startup_one) {
            startActivity(new Intent(StartupOneAct.this, StartupTwoAct.class));
        }
    }
}
