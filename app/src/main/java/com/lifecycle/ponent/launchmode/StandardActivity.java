package com.lifecycle.ponent.launchmode;

import android.os.Bundle;
import android.view.View;

import com.lifecycle.ponent.R;

/**
 * standard
 */
public class StandardActivity extends LaunchModeActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootScView.setBackgroundResource(R.color.bg_green_900);
    }

}
