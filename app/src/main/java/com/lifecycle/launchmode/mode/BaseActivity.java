package com.lifecycle.launchmode.mode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecycle.launchmode.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView mTvStandard;
    protected TextView mTvSingleTop;
    protected TextView mTvSingleTask;
    protected TextView mTvSingleInstance;
    protected TextView mTvSingleTaskAffinity1;
    protected TextView mTvSingleTaskAffinity2;

    protected TextView mTvOtherProcess1;
    protected TextView mTvOtherProcess2;
    protected TextView mTvOtherProcess3;
    protected TextView mTvOtherProcess4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        //打印当前任务栈
        StringBuilder sbtitle = new StringBuilder();
        sbtitle.append(this.getClass().getSimpleName());
        sbtitle.append("\t");
        sbtitle.append(getTaskId());
        setTitle(sbtitle);

        mTvStandard = findViewById(R.id.standard);
        mTvSingleTop = findViewById(R.id.singleTop);
        mTvSingleTask = findViewById(R.id.singleTask);
        mTvSingleInstance = findViewById(R.id.singleInstance);
        mTvSingleTaskAffinity1 = findViewById(R.id.singleTask_taskAffinity1);
        mTvSingleTaskAffinity2 = findViewById(R.id.singleTask_taskAffinity2);

        mTvOtherProcess1 = findViewById(R.id.other_process1);
        mTvOtherProcess2 = findViewById(R.id.other_process2);
        mTvOtherProcess3 = findViewById(R.id.other_process3);
        mTvOtherProcess4 = findViewById(R.id.other_process4);

        bindLinstener();
    }

    @Override
    public void onClick(View v) {
        if (v == mTvStandard) {
            startActivity(new Intent(BaseActivity.this, StandardActivity.class));
        } else if (v == mTvSingleTop) {
            startActivity(new Intent(BaseActivity.this, SingleTopActivity.class));
        } else if (v == mTvSingleTask) {
            startActivity(new Intent(BaseActivity.this, SingleTaskActivity.class));
        } else if (v == mTvSingleInstance) {
            startActivity(new Intent(BaseActivity.this, SingleInstanceActivity.class));
        } else if (v == mTvSingleTaskAffinity1) {
            startActivity(new Intent(BaseActivity.this, ETaskAffinityActivity.class));
        } else if (v == mTvSingleTaskAffinity2) {
            startActivity(new Intent(BaseActivity.this, FTaskAffinityActivity.class));
        } else if (v == mTvOtherProcess1) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activitya");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess2) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityb");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess3) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityc");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess4) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityd");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void bindLinstener() {
        mTvStandard.setOnClickListener(this);
        mTvSingleTop.setOnClickListener(this);
        mTvSingleTask.setOnClickListener(this);
        mTvSingleInstance.setOnClickListener(this);
        mTvSingleTaskAffinity1.setOnClickListener(this);
        mTvSingleTaskAffinity2.setOnClickListener(this);
        mTvOtherProcess1.setOnClickListener(this);
        mTvOtherProcess2.setOnClickListener(this);
        mTvOtherProcess3.setOnClickListener(this);
        mTvOtherProcess4.setOnClickListener(this);
    }

}
