package com.lifecycle.ponent.life;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 *
 */
public class BaseActivity extends AppCompatActivity {
    public static String TAG = "ActivityLifeCycle";

    private String getCurrentMethodName() {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stes) {
            String name = this.getClass().getName();
            if (element.getClassName().equals(name)) {
                if (!element.getMethodName().equals("ALog") && !element.getMethodName().equals("getCurrentMethodName"))
                    return element.getMethodName();
            }
        }
        return "";
    }

    public void ALog() {
        Log.d(TAG, this.getClass().getSimpleName() + ":" + getCurrentMethodName());
    }

}
