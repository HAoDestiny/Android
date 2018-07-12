package com.example.destiny.myapplication.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.util.Tool;
import com.example.destiny.myapplication.view.SwitchView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */
public class DeviceMHSettingFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    //选择按钮模式1/模式2
    @Bind(R.id.btn_md_one_switch)
    SwitchView mSwitchView_md_one;

    @Bind(R.id.btn_md_two_switch)
    SwitchView mSwitchView_md_two;

    //模式选择单选按钮模式1
    @Bind(R.id.cb_btn_md_one_qr)
    CheckBox cbBtnMdOneQr;

    @Bind(R.id.cb_btn_md_one_ic_car)
    CheckBox cbBtnMdOneIcCar;

    @Bind(R.id.cb_btn_md_one_reg_face)
    CheckBox cbBtnMdOneRegFace;

    //模式选择单选按钮模式2
    @Bind(R.id.cb_btn_md_two_qr)
    CheckBox cbBtnMdTwoQr;

    @Bind(R.id.cb_btn_md_two_ic_car)
    CheckBox cbBtnMdTwoIcCar;

    @Bind(R.id.cb_btn_md_two_reg_face)
    CheckBox cbBtnMdTwoRegFace;

    private boolean isModelOneOPen = false, isModelTwoOPen = false;

    public static DeviceMHSettingFragment newInstance() {

        Bundle args = new Bundle();

        DeviceMHSettingFragment fragment = new DeviceMHSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            Log.e("fragment", "当前页：DeviceMHSettingFragment 认证模式");
        }

        Log.e("fragment", "DeviceMHSettingFragment ------- setUserVisibleHint -----" + isVisibleToUser);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Log.e("fragment", "DeviceMHSettingFragment ------- onViewCreated");

        init(view);
        click();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e("fragment", "DeviceMHSettingFragment ------- onCreateView");

        View view = inflater.inflate(R.layout.fragment_device_mh_setting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void init(View view) {

        //初始化单选框
        Tool.setCheckEnable(cbBtnMdOneQr, false);
        Tool.setCheckEnable(cbBtnMdOneIcCar, false);
        Tool.setCheckEnable(cbBtnMdOneRegFace, false);
        Tool.setCheckEnable(cbBtnMdTwoQr, false);
        Tool.setCheckEnable(cbBtnMdTwoIcCar, false);
        Tool.setCheckEnable(cbBtnMdTwoRegFace, false);
    }

    private void click() {

        /* 模式1 - 单一认证 OFF-ON*/
        mSwitchView_md_one.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {

                isModelOneOPen = isOn;
                Tool.setCheckEnable(cbBtnMdOneQr, isOn);
                Tool.setCheckEnable(cbBtnMdOneIcCar, isOn);
                Tool.setCheckEnable(cbBtnMdOneRegFace, isOn);

                if (isOn) {

                    Tool.Toast(getContext(), "ModelOne OFF");
                } else {

                    Tool.Toast(getContext(), "ModelOne ON");
                }

            }
        });

        /* 模式1 - 1+1认证 OFF-ON*/
        mSwitchView_md_two.setOnSwitchStateChangeListener(new SwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {

                isModelTwoOPen = isOn;
                Tool.setCheckEnable(cbBtnMdTwoQr, isOn);
                Tool.setCheckEnable(cbBtnMdTwoIcCar, isOn);
                Tool.setCheckEnable(cbBtnMdTwoRegFace, isOn);

                if (isOn) {

                    Tool.Toast(getContext(), "ModelOne OFF");
                } else {

                    Tool.Toast(getContext(), "ModelOne ON");
                }
            }
        });

        /* 模式1 - 单一认证 单选 */
        cbBtnMdOneQr.setOnCheckedChangeListener(this);
        cbBtnMdOneIcCar.setOnCheckedChangeListener(this);
        cbBtnMdOneRegFace.setOnCheckedChangeListener(this);

        /* 模式2 - 单一认证 单选 */
        cbBtnMdTwoQr.setOnCheckedChangeListener(this);
        cbBtnMdTwoIcCar.setOnCheckedChangeListener(this);
        cbBtnMdTwoRegFace.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {

            /* 模式2 */
            case R.id.cb_btn_md_one_qr:

                Tool.Toast(getActivity(), "modelOne 二维码");
                break;

            case R.id.cb_btn_md_one_ic_car:

                Tool.Toast(getActivity(), "modelOne IC卡");
                break;

            case R.id.cb_btn_md_one_reg_face:

                Tool.Toast(getActivity(), "modelOne 人脸识别");
                break;


            /* 模式2 */
            case R.id.cb_btn_md_two_qr:

                Tool.Toast(getActivity(), "modelTwo 二维码");
                break;

            case R.id.cb_btn_md_two_ic_car:

                Tool.Toast(getActivity(), "modelTwo IC卡");
                break;

            case R.id.cb_btn_md_two_reg_face:

                Tool.Toast(getActivity(), "modelTwo 人脸识别");
                break;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("fragment", "DeviceMHSettingFragment ------- onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("fragment", "DeviceMHSettingFragment ------- onStart");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e("fragment", "DeviceMHSettingFragment ------- onPause");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fragment", "DeviceMHSettingFragment ------- onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);

        Log.e("fragment", "DeviceMHSettingFragment ------- onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

        Log.e("fragment", "DeviceMHSettingFragment ------- onDestroyView");
    }
}
