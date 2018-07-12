package com.example.destiny.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.destiny.myapplication.R;
import com.example.destiny.myapplication.util.AudioUtil;
import com.example.destiny.myapplication.util.Tool;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * created by DESTINY on 2018/7/12
 */

public class MainActivity extends Activity {

    @Bind(R.id.exam_title)
    TextView examTitle;

    @Bind(R.id.tv_exam_num)
    TextView tvExamNum;

    @Bind(R.id.tv_exam_num_left)
    TextView tvExamNumLeft;

    @Bind(R.id.tv_exam_num_right)
    TextView tvExamNumRight;

    @Bind(R.id.tv_exam_order_num)
    TextView tvExamOrderNum;

    @Bind(R.id.tv_exam_order_time)
    TextView tvExamOrderTime;

    @Bind(R.id.tv_exam_next_time)
    TextView tvExamNextTime;

    @Bind(R.id.tv_subject)
    TextView tvSubject;

    @Bind(R.id.tv_next_subject)
    TextView tvNextSubject;

    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        typeface = Typeface.createFromAsset(getAssets(), "fonts/PingFang-Light.ttf");
        tvExamNumLeft.setTypeface(typeface);
        tvExamNumRight.setTypeface(typeface);
        tvExamOrderNum.setTypeface(typeface);

        //考试标题
        examTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommentSettingActivity.class);
                startActivity(intent);
            }
        });

        //考试场数
        tvExamNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        tvExamNumLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeviceMsgActivity.class);
                startActivity(intent);
            }
        });

        tvExamNumRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        //当前考试场数
        tvExamOrderNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });

        //当前考试场次时间
        tvExamOrderTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //TODO
            }
        });

        //下一场考试场次时间
        tvExamNextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //TODO
            }
        });


        //当前考试科目
        tvSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Intent intent = new Intent(MainActivity.this, DataOutPutActivity.class);
                startActivity(intent);
            }
        });

        //下一场考试科目
        tvNextSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });


    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.e("MainActivity", "KEYCODE_VOLUME_DOWN");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.e("MainActivity", "KEYCODE_VOLUME_UP");
                break;
        }
        return true;
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        Log.e("MainActivity", "onKeyDown");
//
//        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
//
//            System.out.println("ddddd--------减小---------");
//
//            AudioUtil.getInstance(MainActivity.this).getAudioManager().adjustStreamVolume(
//                    AudioManager.STREAM_MUSIC,
//                    AudioManager.ADJUST_LOWER,
//                    AudioManager.FX_FOCUS_NAVIGATION_UP
//            );
//
//            return true;
//        }
//
//        else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//
//            System.out.println("dddddd-------增加------");
//
//            AudioUtil.getInstance(MainActivity.this).getAudioManager().adjustStreamVolume (
//                    AudioManager.STREAM_MUSIC,
//                    AudioManager.ADJUST_RAISE,
//                    AudioManager.FX_FOCUS_NAVIGATION_UP
//            );
//
//            return true;
//        }
//
//        else {
//            return super.onKeyDown(keyCode, event);
//        }
//    }
}
