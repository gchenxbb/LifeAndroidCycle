package com.life.otherapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * singleTop模式
 */
public class SingleTop_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
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
    }

}
