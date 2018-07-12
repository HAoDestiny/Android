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
import com.example.destiny.myapplication.view.SwitchView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */
public class DeviceSystemFragment extends Fragment {

    //开关
    @Bind(R.id.btn_switch)
    SwitchView mSwitchBtn;

    //定时开/关 V
    @Bind(R.id.ed_timing_on)
    EditText edTimingOnV;

    @Bind(R.id.ed_timing_off)
    EditText edTimingOFFV;

    //定时开/关 btn
    @Bind(R.id.img_select_time_on)
    ImageView imgSelectTimeOn;

    @Bind(R.id.img_select_time_off)
    ImageView imgSelectTimeOFF;

    private Calendar calendar;

    private boolean isTiming = false; //是否开启定时关机

    public static DeviceSystemFragment newInstance() {

        Bundle args = new Bundle();

        DeviceSystemFragment fragment = new DeviceSystemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e("fragment", "DeviceSystemFragment ------- onCreateView");

        View view = inflater.inflate(R.layout.fragment_device_system_setting, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("fragment", "DeviceSystemFragment ------- onViewCreated");

        ButterKnife.bind(this, view);
        //init view
        init(view);
    }

    private void init(View view) {

        calendar = Calendar.getInstance();

        //mSwitchBtn.setEnabled(true);
        //mSwitchBtn.setOn(false);
        mSwitchBtn.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                Log.e("DeviceSystemFragment", "on click: " + isOn);

                isTiming = isOn;

                if (!isOn) {
                    edTimingOnV.setEnabled(false);
                    edTimingOFFV.setEnabled(false);
                } else {
                    edTimingOnV.setEnabled(true);
                    edTimingOFFV.setEnabled(true);
                }
            }
        });

        //定时开 - value
        imgSelectTimeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTiming) {
                    return;
                }
                DialogUtil.showDatePickerDialog(getActivity(), edTimingOnV, calendar);
            }
        });

        //定时关 - value
        imgSelectTimeOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTiming) {
                    return;
                }
                DialogUtil.showDatePickerDialog(getActivity(), edTimingOFFV, calendar);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("fragment", "DeviceSystemFragment ------- onActivityCreated");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            Log.e("fragment", "当前页：DeviceSystemFragment 开关机设置");
        }

        Log.e("fragment", "DeviceSystemFragment ------- setUserVisibleHint -----" + isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("fragment", "DeviceSystemFragment ------- onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fragment", "DeviceSystemFragment ------- onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e("fragment", "DeviceSystemFragment ------- onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("fragment", "DeviceSystemFragment ------- onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("fragment", "DeviceSystemFragment ------- onDestroyView");
    }
}
