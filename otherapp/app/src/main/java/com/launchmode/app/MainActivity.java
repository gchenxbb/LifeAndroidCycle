package com.launchmode.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected TextView mTvA;
    protected TextView mTvB;
    protected TextView mTvC;
    protected TextView mTvD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            StringBuilder sbtitle = new StringBuilder();
            sbtitle.append(this.getClass().getSimpleName());
            sbtitle.append("\t");
            sbtitle.append(getTaskId());
            getActionBar().setTitle(sbtitle);
        }
        mTvA = findViewById(R.id.tv_a_activity);
        mTvB = findViewById(R.id.tv_b_activity);
        mTvC = findViewById(R.id.tv_c_activity);
        mTvD = findViewById(R.id.tv_d_activity);
        mTvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, A_Activity.class));
            }
        });
        mTvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, B_Activity.class));
            }
        });
        mTvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, C_Activity.class));
            }
        });
        mTvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, D_Activity.class));
            }
        });
    }

}
