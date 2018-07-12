package com.example.destiny.myapplication.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * created by DESTINY on 2018/7/12
 */

public class DialogUtil {

    public static void showDatePickerDialog(final Context context, final EditText editText, final Calendar calendar) {

       final DatePickerDialog dataPickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.e("DeviceSystem(onDateSet)", "年：" + year + ", 月" + monthOfYear + ", 日" + dayOfMonth );
            }
        }, calendar.get(Calendar.YEAR),
           calendar.get(Calendar.MONTH),
           calendar.get(Calendar.DAY_OF_MONTH)
        );

        dataPickerDialog.setTitle("日期选择");
        dataPickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DatePicker picker = dataPickerDialog.getDatePicker();

                editText.setText("");
                editText.setText(picker.getYear() + "-" + formatDateTime(picker.getMonth()) + "-" + formatDateTime(picker.getDayOfMonth()));

                showTimePickerDialog(context, editText, calendar);
                Log.e("DeviceSystemFragment: ", picker.getYear() + "-" +  formatDateTime( picker.getMonth()) + "-" + formatDateTime(picker.getDayOfMonth()) + "-"  );
                Tool.Toast(context, picker.getYear() + "-" +  formatDateTime( picker.getMonth()) + "-" + formatDateTime(picker.getDayOfMonth()));
            }
        });

        dataPickerDialog.getDatePicker().setMinDate((new Date()).getTime()); //最小
        dataPickerDialog.show();

    }

    public static void showTimePickerDialog(final Context context, final EditText editText, Calendar calendar) {

        final TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                editText.setText(editText.getText() + " " + formatDateTime(hourOfDay) + " : " + formatDateTime(minute));
                Log.e("DeviceSystemFragment: ",  hourOfDay + " : " + minute);
                Tool.Toast(context, hourOfDay + " : " + minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);

        timePickerDialog.setTitle("时间选择");
        timePickerDialog.show();
    }

    private static String formatDateTime(int value) {
        if (value < 10) {
            return "0" + value;
        }

        return String.valueOf(value);
    }
}
