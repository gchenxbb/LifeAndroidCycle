package com.lifecycle.ponent.mode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecycle.ponent.R;

/**
 * 基类，启动模式中所有测试类都继承它。
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView mTvStandard;
    protected TextView mTvSingleTop;
    protected TextView mTvSingleTask;
    protected TextView mTvSingleInstance;
    protected TextView mTvSingleTaskAffinity1;
    protected TextView mTvSingleTaskAffinity2;

    protected TextView mTvSingleTaskCode;

    protected TextView mTvOtherProcess1;
    protected TextView mTvOtherProcess2;
    protected TextView mTvOtherProcess3;
    protected TextView mTvOtherProcess4;
    protected TextView mTvOtherProcess5;
    protected TextView mTvOtherProcess6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        //打印当前任务栈
        StringBuilder sbtitle = new StringBuilder();
        sbtitle.append(this.getClass().getSimpleName());
        sbtitle.append("\t");
        sbtitle.append("任务栈Id");
        sbtitle.append("\t");
        sbtitle.append(getTaskId());
        setTitle(sbtitle);

        bindView();
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
            startActivity(new Intent(BaseActivity.this, TaskAffinity1Activity.class));
        } else if (v == mTvSingleTaskAffinity2) {
            startActivity(new Intent(BaseActivity.this, TaskAffinity2Activity.class));
        } else if (v == mTvSingleTaskCode) {
//            1.在Activity上下文之外启动Activity需要给Intent设置FLAG_ACTIVITY_NEW_TASK标志，不然会报异常。
//            2.加了该标志，如果在同一个应用中进行Activity跳转，不会创建新的Task，只有在不同的应用中跳转才会创建新的Task
            Intent intent = new Intent(BaseActivity.this, SingleTaskActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
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
                intent.setAction("com.launchmode.app.activitya_atr");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess3) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityb");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess4) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityb_atr");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess5) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityc");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        } else if (v == mTvOtherProcess6) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.launchmode.app.activityc_af");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(BaseActivity.this, e.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void bindView() {
        mTvStandard = findViewById(R.id.standard);
        mTvSingleTop = findViewById(R.id.singleTop);
        mTvSingleTask = findViewById(R.id.singleTask);
        mTvSingleInstance = findViewById(R.id.singleInstance);
        mTvSingleTaskAffinity1 = findViewById(R.id.singleTask_taskAffinity1);
        mTvSingleTaskAffinity2 = findViewById(R.id.singleTask_taskAffinity2);

        mTvSingleTaskCode = findViewById(R.id.singleTask_code);

        mTvOtherProcess1 = findViewById(R.id.other_process1);
        mTvOtherProcess2 = findViewById(R.id.other_process2);
        mTvOtherProcess3 = findViewById(R.id.other_process3);
        mTvOtherProcess4 = findViewById(R.id.other_process4);
        mTvOtherProcess5 = findViewById(R.id.other_process5);
        mTvOtherProcess6 = findViewById(R.id.other_process6);
    }

    private void bindLinstener() {
        mTvStandard.setOnClickListener(this);
        mTvSingleTop.setOnClickListener(this);
        mTvSingleTask.setOnClickListener(this);
        mTvSingleInstance.setOnClickListener(this);
        mTvSingleTaskAffinity1.setOnClickListener(this);
        mTvSingleTaskAffinity2.setOnClickListener(this);

        mTvSingleTaskCode.setOnClickListener(this);

        mTvOtherProcess1.setOnClickListener(this);
        mTvOtherProcess2.setOnClickListener(this);
        mTvOtherProcess3.setOnClickListener(this);
        mTvOtherProcess4.setOnClickListener(this);
        mTvOtherProcess5.setOnClickListener(this);
        mTvOtherProcess6.setOnClickListener(this);
    }

}
