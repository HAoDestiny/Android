package com.example.destiny.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.util.Tool;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */

public class DataOutPutActivity extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    @Bind(R.id.btn_img_back)
    ImageView btnImgBack; //back

    @Bind(R.id.cb_data_type_attendance)
    CheckBox cbDataTypeAttendance; //考勤

    @Bind(R.id.cb_data_type_log)
    CheckBox cbDataTypeLog; //日志

    @Bind(R.id.cb_data_type_conf)
    CheckBox cbDataTypeConf; //配置

    @Bind(R.id.cb_data_type_action_log)
    CheckBox cbDataTypeActionLog; //操作日志

    @Bind(R.id.btn_next)
    Button btnNext; //下一步

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_output);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        cbDataTypeAttendance.setEnabled(true);
        cbDataTypeAttendance.setOnCheckedChangeListener(this);
        cbDataTypeLog.setOnCheckedChangeListener(this);
        cbDataTypeConf.setOnCheckedChangeListener(this);
        cbDataTypeActionLog.setOnCheckedChangeListener(this);

        //next
        btnNext.setOnClickListener(this);

        //back
        btnImgBack.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

            case R.id.cb_data_type_attendance:
                //TODO
                Tool.snackbarToast(buttonView, "考情数据 " + isChecked);
                break;

            case R.id.cb_data_type_log:
                Tool.snackbarToast(buttonView, "日志信息 " + isChecked);
                //TODO
                break;

            case R.id.cb_data_type_conf:
                Tool.snackbarToast(buttonView, "配置数据 " + isChecked);
                //TODO
                break;

            case R.id.cb_data_type_action_log:
                Tool.snackbarToast(buttonView, "操作日志 " + isChecked);
                //TODO
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_next:
                //TODO
                Tool.snackbarToast(v, "下一步");
                break;

            case R.id.btn_img_back:
                //TODO
                Tool.snackbarToast(v, "back");
                this.finish();
                break;
        }
    }
}
