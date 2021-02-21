package com.intent.filter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.ponent.R;

public class IntentMainActivity extends Activity {
    TextView mTextViewAction;
    TextView mTextViewCategory;
    TextView mTextViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);
        mTextViewAction = findViewById(R.id.tv_intent_action);
        mTextViewCategory = findViewById(R.id.tv_intent_category);
        mTextViewData = findViewById(R.id.tv_intent_data);

        mTextViewAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //至少一个action,一定得在AndroidManifest.xml文件的<intent-filter>找到匹配者
                intent.setAction("com.intent.intentfilter.action.one");
                startActivity(intent);
            }
        });
        mTextViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                //至少一个action,一定得在AndroidManifest.xml文件的<intent-filter>找到匹配者
                //不能只有categary
                mIntent.setAction("com.intent.intentfilter.action.four");
                //如果有add category，则add的每一项需要在<intent-filter>中找到才能匹配
                mIntent.addCategory("com.intent.intentfilter.category");
                mIntent.addCategory("com.intent.intentfilter.category.two");
                //会自动加上DEFAULT
                startActivity(mIntent);
            }
        });

        mTextViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.setAction("com.intent.intentfilter.action.five");
                mIntent.addCategory("com.intent.intentfilter.category.five");

                //<intent-filter>配置了mimeType(可多个)，Intent设置type应与其中一个匹配，不能不设置。
                //<intent-filter>可不配置URI,<intent-filter>默认支持content
                //如果不配置，默认就是content，Uri必须用content
                mIntent.setDataAndType(Uri.parse("content://com.intent:85/path/iactivity"), "image/*");
//                mIntent.setType("video/*");//data单独这一项也可以匹配
                startActivity(mIntent);
            }
        });


    }
}
