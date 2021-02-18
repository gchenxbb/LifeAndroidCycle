package com.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lifecycle.launchmode.R;

public class MainFragmentActivity extends AppCompatActivity {
    HomeFragment mHomeFragment;
    PageFragment mPageFragment;
    FindFragment mFindFragment;
    MineFragment mMineFragment;

    BaseFragment mCurrentFragment;
    FooterViewMenu footerViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        mHomeFragment = new HomeFragment();
        mPageFragment = new PageFragment();
        mFindFragment = new FindFragment();
        mMineFragment = new MineFragment();

        switchFragment(R.id.fl_main_container, mHomeFragment);
//        replaceFragment(R.id.fl_main_container, mHomeFragment);


        footerViewMenu = findViewById(R.id.footer_view_menu);
        footerViewMenu.setOnMenuItemListener(new FooterViewMenu.OnMenuItemListener() {

            @Override
            public void onItemClickListener(int itemStrId) {
                switch (itemStrId) {
                    case R.string.str_bottom_a:
                        switchFragment(R.id.fl_main_container, mHomeFragment);
//                        replaceFragment(R.id.fl_main_container, mHomeFragment);
                        break;
                    case R.string.str_bottom_b:
                        switchFragment(R.id.fl_main_container, mPageFragment);
//                        replaceFragment(R.id.fl_main_container, mPageFragment);
                        break;
                    case R.string.str_bottom_c:
                        switchFragment(R.id.fl_main_container, mFindFragment);
//                        replaceFragment(R.id.fl_main_container, mFindFragment);
                        break;
                    case R.string.str_bottom_d:
                        switchFragment(R.id.fl_main_container, mMineFragment);
//                        replaceFragment(R.id.fl_main_container, mMineFragment);
                        break;
                    default:
                        break;
                }
            }
        });
    }

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
        ft.replace(container,targetFragment).commitAllowingStateLoss();
    }


}