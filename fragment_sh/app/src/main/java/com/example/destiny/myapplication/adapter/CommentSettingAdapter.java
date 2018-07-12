package com.example.destiny.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * created by DESTINY on 2018/7/12
 */

public class CommentSettingAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String[] pageTitleList;

    public CommentSettingAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList, String[] pageTitleList) {
        super(fragmentManager);

        this.fragmentList = fragmentList;
        this.pageTitleList = pageTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitleList[position];
    }
}
