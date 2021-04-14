package com.life.otherapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * standard + allowTaskReparenting
 */
public class Standard_aTR_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setTaskId();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(Standard_aTR_Activity.this, "onNewIntent == > 调用：" + intent.getPackage(), Toast.LENGTH_LONG).show();
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
        Toast.makeText(Standard_aTR_Activity.this, "setTaskId == > 调用:" + getTaskId(), Toast.LENGTH_LONG).show();
    }

}
