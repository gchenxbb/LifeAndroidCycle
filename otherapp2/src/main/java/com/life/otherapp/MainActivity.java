package com.life.otherapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * otherapp main
 */
public class MainActivity extends Activity {
    protected TextView mTv1;
    protected TextView mTv2;
    protected TextView mTv3;
    protected TextView mTv4;
    protected TextView mTv5;
    protected TextView mTv6;
    protected TextView mTv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();

        //打印当前任务栈
        if (actionBar != null) {
            StringBuilder sbtitle = new StringBuilder();
            sbtitle.append(this.getClass().getSimpleName());
            sbtitle.append("\t");
            sbtitle.append("任务栈Id");
            sbtitle.append("\t");
            sbtitle.append(getTaskId());
            getActionBar().setTitle(sbtitle);
        }

        mTv1 = findViewById(R.id.tv_standard);
        mTv2 = findViewById(R.id.tv_standard_atr);
        mTv3 = findViewById(R.id.tv_singleTop);
        mTv4 = findViewById(R.id.tv_singleTop_atr);
        mTv5 = findViewById(R.id.tv_singleTask);
        mTv6 = findViewById(R.id.tv_singleTask_af);
        mTv7 = findViewById(R.id.tv_send_broadex);

        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Standard_Activity.class));
            }
        });
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Standard_aTR_Activity.class));
            }
        });
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleTop_Activity.class));
            }
        });
        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleTop_aTR_Activity.class));
            }
        });
        mTv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleTask_Activity.class));
            }
        });
        mTv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleTask_Af_Activity.class));
            }
        });
        mTv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.ponent.receiver.DY_ACTION");
                sendBroadcast(intent);
            }
        });
    }

}
