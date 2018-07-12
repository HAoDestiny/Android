package com.example.destiny.myapplication.activity.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.util.AudioUtil;
import com.example.destiny.myapplication.util.Tool;
import com.example.destiny.myapplication.view.SwitchView;
import com.xw.repo.BubbleSeekBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */
public class DeviceSoundSettingFragment extends Fragment {

    @Bind(R.id.btn_sound_switch)
    SwitchView mSwitchView;

    @Bind(R.id.seek_bar_sound)
    BubbleSeekBar mSeekBar;

    private int sound; //声音值

    private boolean isSoundOpen = true;
    private boolean isVilible = false;

    public static DeviceSoundSettingFragment newInstance() {

        Bundle args = new Bundle();

        DeviceSoundSettingFragment fragment = new DeviceSoundSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        isVilible = isVisibleToUser;
        //当前页是否可视
        if (isVisibleToUser) {
            Log.e("fragment", "当前页：DeviceSoundSettingFragment 声音设置");
        }

        Log.e("fragment", "DeviceSoundSettingFragment ------- setUserVisibleHint -----" + isVisibleToUser);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_device_sound_setting, container, false);

        Log.e("fragment", "DeviceSoundSettingFragment ------- onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("fragment", "DeviceSoundSettingFragment ------- onViewCreated");

        ButterKnife.bind(this, view);

        click();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sound = AudioUtil.getInstance(getContext()).getMediaVolume();
        Log.e("fragment", "DeviceDateSettingFragment ------- 音量初始化 " + sound);

        mSeekBar.setProgress(sound);

        Log.e("fragment", "DeviceDateSettingFragment ------- onActivityCreated");
    }

    //TODO
    private void click() {

        mSwitchView.setOn(true);
        mSwitchView.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {

                isSoundOpen = isOn;

                //开
                if (isOn) {
                    Tool.Toast(getContext(), "true");
                    mSeekBar.setEnabled(true);
                    sound = AudioUtil.getInstance(getContext()).getMediaVolume();
                    mSeekBar.setThumbColor(ContextCompat.getColor(getActivity(), R.color.title_left_view_bg));
                    mSeekBar.setSecondTrackColor(ContextCompat.getColor(getActivity(), R.color.title_left_view_bg));
                }

                //关
                else {
                    Tool.Toast(getContext(), "false");
                    mSeekBar.setEnabled(false);
                    mSeekBar.setThumbColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                    mSeekBar.setSecondTrackColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

                    sound = 0;
                }

                //当前页不可见
                if (!isVilible) {
                    return;
                }

                AudioUtil.getInstance(getContext()).setMediaVolume(sound);
            }
        });

        //自定义
        mSeekBar.setCustomSectionTextArray(new BubbleSeekBar.CustomSectionTextArray() {
            @NonNull
            @Override
            public SparseArray<String> onCustomize(int sectionCount, @NonNull SparseArray<String> array) {

                array.clear();
                array.put(1, "20");
                array.put(2, "40");
                array.put(3, "60");
                array.put(4, "80");
                array.put(5, "100");

                return array;
            }
        });

        mSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
//                int color;
//                if (progress <= 10) {
//                    color = ContextCompat.getColor(getActivity(), R.color.color_blue);
//                }
//
//                else {
//                    color = ContextCompat.getColor(getActivity(), R.color.color_green);
//
//                }

                //mSwitchView 是否打开
                if (!isVilible || !isSoundOpen) {
                   return;
                }

                //bubbleSeekBar.setSecondTrackColor(color);
                //bubbleSeekBar.setThumbColor(color);
                //bubbleSeekBar.setBubbleColor(color);

                AudioUtil.getInstance(getContext()).setMediaVolume(progress);
                Log.e("systemMedle", "媒体音量" +  AudioUtil.getInstance(getContext()).getMediaVolume());
                Log.e("mSeekBar", progress + "");
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("fragment", "DeviceSoundSettingFragment ------- onStart");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e("fragment", "DeviceSoundSettingFragment ------- onPause");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fragment", "DeviceSoundSettingFragment ------- onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("fragment", "DeviceSoundSettingFragment ------- onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        isVilible = false;
        Log.e("fragment", "DeviceSoundSettingFragment ------- onDestroyView");
    }
}
