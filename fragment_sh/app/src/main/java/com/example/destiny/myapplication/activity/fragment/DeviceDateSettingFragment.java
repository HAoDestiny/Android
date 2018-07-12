package com.example.destiny.myapplication.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.util.DialogUtil;
import com.example.destiny.myapplication.util.Tool;
import com.example.destiny.myapplication.view.SwitchView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */
public class DeviceDateSettingFragment extends Fragment {

    //服务器校时
    @Bind(R.id.btn_date_server_switch)
    SwitchView autoTimingSwitch;

    //自动校时
    @Bind(R.id.btn_date_auto_switch)
    SwitchView manualTimingSwitch;

    //手动时间
    @Bind(R.id.ed_timing_manual)
    EditText edTiming;

    //选择时间
    @Bind(R.id.img_select_timing_manual)
    ImageView manualSelectTiming;

    private Calendar calendar;

    public static DeviceDateSettingFragment newInstance() {

        Bundle args = new Bundle();

        DeviceDateSettingFragment fragment = new DeviceDateSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            Log.e("fragment", "当前页：DeviceDateSettingFragment 日期设置");
        }

        Log.e("fragment", "DeviceDateSettingFragment ------- setUserVisibleHint -----" + isVisibleToUser);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e("fragment", "DeviceDateSettingFragment ------- onCreateView");

        View view = inflater.inflate(R.layout.fragment_device_date_setting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("fragment", "DeviceDateSettingFragment ------- onViewCreated");

        ButterKnife.bind(this, view);

        calendar = Calendar.getInstance();

        click();
    }

    //TODO
    private void click() {

        //服务器校时 OFF/ON
        autoTimingSwitch.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                Log.e("autoTimingSwitch", "autoTimingSwitch SERVER TIME " + isOn);
                Tool.snackbarToast(getView(), "autoTimingSwitch SERVER TIME " + isOn);
            }
        });

        //自动校时 OFF/ON
        manualTimingSwitch.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                Log.e("manualTimingSwitch", "manualTimingSwitch SERVER TIME " + isOn);
                Tool.snackbarToast(getView(), "manualTimingSwitch SERVER TIME " + isOn);
            }
        });

        manualSelectTiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showDatePickerDialog(getContext(), edTiming, calendar);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("fragment", "DeviceDateSettingFragment ------- onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("fragment", "DeviceDateSettingFragment ------- onStart");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e("fragment", "DeviceDateSettingFragment ------- onPause");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fragment", "DeviceDateSettingFragment ------- onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("fragment", "DeviceDateSettingFragment ------- onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("fragment", "DeviceDateSettingFragment ------- onDestroyView");
    }
}
