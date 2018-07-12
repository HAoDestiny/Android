package com.example.destiny.myapplication.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.destiny.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */

public class NoticeActivity extends Activity {

    @Bind(R.id.tv_notice_action_title)
    TextView tvNoticeActionTitle;

    @Bind(R.id.tv_notice_title)
    TextView tvNoticeTitle;

    @Bind(R.id.tv_notice_content)
    TextView tvNoticeContent;

    @Bind(R.id.tv_notice_release_dp_vl_r)
    TextView tvNoticeReleaseDpVlR;

    @Bind(R.id.tv_notice_time_vl_r)
    TextView tvNoticeTimeVlR;

    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        typeface = Typeface.createFromAsset(getAssets(), "fonts/PingFang-Light.ttf");

        tvNoticeTitle.setTypeface(typeface);
        tvNoticeContent.setTypeface(typeface);
        tvNoticeTimeVlR.setTypeface(typeface);
        tvNoticeActionTitle.setTypeface(typeface);
        tvNoticeReleaseDpVlR.setTypeface(typeface);
    }
}
