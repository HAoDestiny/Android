package com.example.destiny.myapplication.activity;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.activity.fragment.DeviceDateSettingFragment;
import com.example.destiny.myapplication.activity.fragment.DeviceMHSettingFragment;
import com.example.destiny.myapplication.activity.fragment.DeviceSoundSettingFragment;
import com.example.destiny.myapplication.activity.fragment.DeviceSystemFragment;
import com.example.destiny.myapplication.adapter.CommentSettingAdapter;
import com.example.destiny.myapplication.util.AudioUtil;
import com.example.destiny.myapplication.util.Tool;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */

public class CommentSettingActivity extends AppCompatActivity {


    @Bind(R.id.tag_setting)
    TabLayout titleTag;

    @Bind(R.id.setting_view_pager)
    ViewPager settingViewPager;

    private CommentSettingAdapter adapter;

    private String[] pageTitleList;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_setting);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        titleTag.addTab(titleTag.newTab().setText("wocaonima"));
        Tool.reflexTabLayoutLine(titleTag);

        fragments = new ArrayList<>();
        fragments.add(DeviceDateSettingFragment.newInstance()); //开关机设置
        fragments.add(DeviceSoundSettingFragment.newInstance()); //声音
        fragments.add(DeviceSystemFragment.newInstance()); //账户设置
        fragments.add(DeviceMHSettingFragment.newInstance()); //日期设置

        pageTitleList =  new String[]{
                getString(R.string.tx_setting_account),
                getString(R.string.tx_setting_sound),
                getString(R.string.tx_setting_on_off),
                getString(R.string.tx_setting_mh)
        };

        for (String title : pageTitleList) {
            titleTag.addTab(titleTag.newTab().setText(title));
        }

        adapter = new CommentSettingAdapter(getSupportFragmentManager(), fragments, pageTitleList);

        settingViewPager.setAdapter(adapter);

        titleTag.setupWithViewPager(settingViewPager); //关联

        //监听
        settingViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("fragment : ", "select page:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //监听
        titleTag.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tab被选的时候回调
                settingViewPager.setCurrentItem(tab.getPosition());
                Log.e("fragment", tab.getPosition() + "");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab未被选择的时候回调
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //tab重新选择的时候回调
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
            AudioUtil.getInstance(this).getAudioManager().adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, 0);
        }else if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
            AudioUtil.getInstance(this).getAudioManager().adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, 0);
        }
        return true;
    }
}
