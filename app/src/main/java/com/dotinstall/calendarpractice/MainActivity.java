package com.dotinstall.calendarpractice;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import java.util.Calendar;
import android.icu.util.TimeZone;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nextMonthButton = null;				//次の月へボタン
    private TextView previousMonthButton = null;			//前の月へボタン
    private TextView headerMonthText = null;			//年月表示テキストビュー

    private int currentYear = 0;						//現在表示中の年
    private int currentMonth = 0;						//現在表示中の月

    private int nowYear = 0;							//現在の年
    private int nowMonth = 0;							//現在の月
    private int nowDay = 0;								//現在の日

    //日表示テキスト情報リスト
    private ArrayList<DayTextViewInfo> dayTextList = new ArrayList<DayTextViewInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_frame);

        /*
        // 現在日時の取得
        Date now = new Date(System.currentTimeMillis());
        // 日時のフォーマットオブジェクト作成
        DateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT")); //タイムゾーン変更？
        Log.e("formatter", formatter.toString());


        // フォーマット
        String nowText = formatter.format(now);
        // 表示
        TextView textView = (TextView) findViewById(R.id.todayTextView);
        textView.setText(nowText);
        */

        initializeControl();

    }



        /**
         * 各コントロール初期化
         */

    private void initializeControl() {

        this.nextMonthButton = (TextView) findViewById(R.id.moveMonthTextView);
        Log.e("nextMonth", nextMonthButton.toString());
        this.nextMonthButton.setOnClickListener(this);
        this.previousMonthButton = (TextView) findViewById(R.id.backMonthTextView);
        this.previousMonthButton.setOnClickListener(this);

        this.headerMonthText = (TextView)findViewById(R.id.todayTextView);

        DayTextViewInfo info = null;

        info = new DayTextViewInfo(R.id.one_su_text);
        this.dayTextList.add(info);
        Log.e("dayText", dayTextList.toString());
        info = new DayTextViewInfo(R.id.one_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.two_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.two_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.three_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.four_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.five_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_sa_text);
        this.dayTextList.add(info);

        Calendar cal1 = Calendar.getInstance();            //(1)オブジェクトの生成
        Log.e("cal1GetInstance", cal1.toString());

        this.currentYear = cal1.get(Calendar.YEAR);        //(2)現在の年を取得
        Log.e("cal1Year", cal1.toString());

        this.currentMonth = cal1.get(Calendar.MONTH) + 1;  //(3)現在の月を取得
        Log.e("cal1Month", cal1.toString());

        this.nowYear = this.currentYear;
        this.nowMonth = this.currentMonth;
        this.nowDay = cal1.get(Calendar.DATE);                //(4)現在の日を取得
        Log.e("cal1NowDay", cal1.toString());


        int id = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                TextView tv = (TextView) findViewById(this.dayTextList.get(id).getTextViewId());
                tv.setOnClickListener(this);

                tv.setBackgroundResource(R.drawable.text_day_line);
                if (j == 0) {
                    //日曜日
                    tv.setTextColor(Color.RED);
                }
                if (j == 6) {
                    //土曜日
                    tv.setTextColor(Color.BLUE);
                }
                this.dayTextList.get(id).setTextObject(tv);
                id++;
            }
        }

        this.SetCalendar(0);
    }






    /**
     * カレンダー再描画
     */
    private void SetCalendar(int offset) {
        this.currentMonth += offset;

        if(currentMonth > 12){
            this.currentYear += 1;
            this.currentMonth = 1;
        }
        else if(currentMonth == 0){
            this.currentMonth = 12;
            this.currentYear -= 1;
        }

        //テキスト表示情報初期化
        for(int i = 0 ; i < this.dayTextList.size(); i++) {
            DayTextViewInfo tg = this.dayTextList.get(i);
            if(tg.isNowDay() || tg.isSelected() ) {
                tg.getTextObject().setBackgroundResource(R.drawable.text_day_line);
            }

            tg.setNowDay(false);
            tg.setDayNum(0);
            tg.setSelected(false);
            tg.getTextObject().setText(tg.getDispString());
            //Log.e("tg", tg.toString());

        }

        //カレンダーテーブル作成
        CalendarInfo cl = new CalendarInfo(currentYear, currentMonth);

        int row = 0;
        int col = 0;
        for(int i = 0 ; i < this.dayTextList.size(); i++) {
            DayTextViewInfo tg = this.dayTextList.get(i);

            if(cl.calendarMatrix[row][col] != 0) {
                // 日付表示
                tg.setDayNum(cl.calendarMatrix[row][col]);
                Log.e("setDayNum", cl.toString());
                tg.getTextObject().setText(tg.getDispString());
                if(this.nowYear == this.currentYear
                        && this.nowMonth == this.currentMonth
                        && cl.calendarMatrix[row][col] == nowDay) {

                    // 当日日付表示
                    this.dayTextList.get(i).setNowDay(true);
                    //tg.getTextObject().setBackgroundResource(R.drawable.text_now_line);
                }
            }

            col += 1;
            if(col == 7){
                row += 1;
                col = 0;
            }
        }

        //年月表示
        /*
        this.headerMonthText.setText(String.valueOf(this.currentYear)
                + "年" + String.valueOf(this.currentMonth) + "月" ); */


    }

    public void onClick(View v) {
        // TODO 自動生成されたメソッド・スタブ
        if(v.getId() == R.id.moveMonthTextView) {
            this.SetCalendar(+1);
        }
        else if(v.getId() == R.id.backMonthTextView) {
            this.SetCalendar(-1);
        }
        else
        {
            for(int i = 0 ; i < this.dayTextList.size(); i++) {
                if(this.dayTextList.get(i).getTextViewId() == v.getId()) {
                    //this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_selected_line);
                    this.dayTextList.get(i).setSelected(true);
                }
                else {
                    if(this.dayTextList.get(i).isNowDay() == true) {
                        //this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_now_line);
                        this.dayTextList.get(i).setSelected(false);
                    }
                    else if(this.dayTextList.get(i).isSelected()) {
                        this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_day_line);
                        this.dayTextList.get(i).setSelected(false);
                    }
                }
            }
        }

    }






}
