package com.launchmode.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class C_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            StringBuilder sbtitle = new StringBuilder();
            sbtitle.append(this.getClass().getSimpleName());
            sbtitle.append("\t");
            sbtitle.append(getTaskId());
            getActionBar().setTitle(sbtitle);
        }
    }

}
