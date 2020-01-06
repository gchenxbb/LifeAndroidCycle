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


    protected TextView mTvOtherProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

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

        mTvOtherProcess = findViewById(R.id.other_process);

        bindLinstener();
    }

    @Override
    public void onClick(View v) {
        if (v == mTvStandard) {
            startActivity(new Intent(BaseActivity.this, AActivity.class));
        } else if (v == mTvSingleTop) {
            startActivity(new Intent(BaseActivity.this, BActivity.class));
        } else if (v == mTvSingleTask) {
            startActivity(new Intent(BaseActivity.this, CActivity.class));
        } else if (v == mTvSingleInstance) {
            startActivity(new Intent(BaseActivity.this, DActivity.class));
        } else if (v == mTvSingleTaskAffinity1) {
            startActivity(new Intent(BaseActivity.this, EActivity.class));
        } else if (v == mTvSingleTaskAffinity2) {
            startActivity(new Intent(BaseActivity.this, FActivity.class));
        } else if (v == mTvOtherProcess) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activity");
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
        mTvOtherProcess.setOnClickListener(this);
    }


}
