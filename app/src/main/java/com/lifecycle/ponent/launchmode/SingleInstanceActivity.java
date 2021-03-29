package com.lifecycle.ponent.launchmode;
import android.os.Bundle;

import com.lifecycle.ponent.R;

/**
 * singleInstance
 */
public class SingleInstanceActivity extends LaunchModeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootScView.setBackgroundResource(R.color.bg_green_300);
    }

}
