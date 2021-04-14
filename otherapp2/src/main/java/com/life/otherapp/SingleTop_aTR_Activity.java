package com.life.otherapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * singleTop + allowTaskReparenting
 * 该activity被其他app进程打开
 * 允许在其他进程退后台时，该activity回到该进程(主宿)app栈，如果该进程已经又栈在后台，会新建一个栈给它用。
 */
public class SingleTop_aTR_Activity extends Activity {

    private static final String TAG = "SingleTop_aTR_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTaskId();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, getClass().getSimpleName() + ":" + "onNewIntent == > 调用");
        Toast.makeText(SingleTop_aTR_Activity.this, getClass().getSimpleName() + ":" + "onNewIntent == > 调用：" + intent.getPackage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //打印在回到主宿app栈的时，是否发生了改变
        setTaskId();
    }

    private void setTaskId() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            StringBuilder sbtitle = new StringBuilder();
            sbtitle.append(this.getClass().getSimpleName());
            sbtitle.append("\t");
            sbtitle.append("任务栈Id");
            sbtitle.append("\t");
            sbtitle.append(getTaskId());
            getActionBar().setTitle(sbtitle);
        }
        Toast.makeText(SingleTop_aTR_Activity.this, "setTaskId == > 调用:" + getTaskId(), Toast.LENGTH_LONG).show();
    }

}
