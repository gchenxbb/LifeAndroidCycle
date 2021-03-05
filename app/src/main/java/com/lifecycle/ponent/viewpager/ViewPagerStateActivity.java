package com.lifecycle.ponent.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lifecycle.ponent.R;
import com.lifecycle.ponent.homefragment.BottomBarEntity;
import com.lifecycle.ponent.homefragment.FindFragment;
import com.lifecycle.ponent.homefragment.FooterBarView;
import com.lifecycle.ponent.homefragment.HomeFragment;
import com.lifecycle.ponent.homefragment.HomeVPAdapter;
import com.lifecycle.ponent.homefragment.MineFragment;
import com.lifecycle.ponent.homefragment.PageFragment;
import com.lifecycle.ponent.launchmode.LaunchModeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * standard
 */
public class ViewPagerStateActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentVPAdapter fragmentVPAdapter;
    private FragmentStateVPAdapter fragmentStateVPAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        initView();
    }

    void initView() {
        viewPager = findViewById(R.id.vp_state);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ViewPagerFragA());
        fragmentList.add(new ViewPagerFragB());
        fragmentList.add(new ViewPagerFragC());

        fragmentStateVPAdapter = new FragmentStateVPAdapter(getSupportFragmentManager(), fragmentList);
        fragmentVPAdapter = new FragmentVPAdapter(getSupportFragmentManager(), fragmentList);


//        viewPager.setAdapter(fragmentVPAdapter);
        viewPager.setAdapter(fragmentStateVPAdapter);

        viewPager.setOffscreenPageLimit(1);
    }

}
