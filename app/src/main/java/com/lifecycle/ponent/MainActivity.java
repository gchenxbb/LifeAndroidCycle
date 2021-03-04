package com.lifecycle.ponent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lifecycle.ponent.fragment.BaseFragment;
import com.lifecycle.ponent.fragment.BottomBarEntity;
import com.lifecycle.ponent.fragment.FindFragment;
import com.lifecycle.ponent.fragment.FooterBarView;
import com.lifecycle.ponent.fragment.HomeFragment;
import com.lifecycle.ponent.fragment.HomeVPAdapter;
import com.lifecycle.ponent.fragment.MineFragment;
import com.lifecycle.ponent.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class MainActivity extends AppCompatActivity {
    BaseFragment mCurrentFragment;
    FooterBarView footerBarView;

    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        viewPager = findViewById(R.id.vp_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new PageFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MineFragment());

        fragmentPagerAdapter = new HomeVPAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fragmentPagerAdapter);

        footerBarView = findViewById(R.id.footer_view_menu);
        footerBarView.setOnMenuItemListener(new FooterBarView.OnMenuItemListener() {
            @Override
            public void onItemClickListener(BottomBarEntity entity) {
                viewPager.setCurrentItem(entity.index, false);
            }
        });

        viewPager.setOffscreenPageLimit(1);
    }

    /**
     * add hide
     *
     * @param container
     * @param targetFragment
     */
    public void switchFragment(int container, BaseFragment targetFragment) {
        if (mCurrentFragment == targetFragment || targetFragment == null) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (mCurrentFragment != null) {
            ft.hide(mCurrentFragment);
        }
        if (!targetFragment.isAdded()) {
            ft.add(container, targetFragment);
        }
        mCurrentFragment = targetFragment;
        ft.show(targetFragment).commitAllowingStateLoss();
    }


    /**
     * replace
     *
     * @param container
     * @param targetFragment
     */
    public void replaceFragment(int container, BaseFragment targetFragment) {
        if (mCurrentFragment == targetFragment || targetFragment == null) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        mCurrentFragment = targetFragment;
        ft.replace(container, targetFragment).commitAllowingStateLoss();
    }
}