package com.example.destiny.myapplication.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.destiny.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */

public class CourseActivity extends Activity {

    @Bind(R.id.tv_course_name)
    TextView tvCourseName;

    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        typeface = Typeface.createFromAsset(getAssets(), "fonts/PingFang-Light.ttf");
        tvCourseName.setTypeface(typeface);
    }
}
