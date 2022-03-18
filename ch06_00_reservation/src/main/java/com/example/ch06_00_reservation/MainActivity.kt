package com.example.ch06_00_reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() 
{
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "예약 프로그램"
        
        var chrono = findViewById<Chronometer>(R.id.chrono1);
        var btnStart = findViewById<Button>(R.id.btnStart);

        var rdoDate = findViewById<RadioButton>(R.id.rdoDate);
        var rdoTime = findViewById<RadioButton>(R.id.rdoTime);

        var cv = findViewById<CalendarView>(R.id.cv1);
        var tp = findViewById<TimePicker>(R.id.tp1);

        var btnFinish = findViewById<Button>(R.id.btnFinish);

        var tvYear = findViewById<TextView>(R.id.tvYear);
        var tvMonth = findViewById<TextView>(R.id.tvMonth);
        var tvDay = findViewById<TextView>(R.id.tvDay);

        var tvHour = findViewById<TextView>(R.id.tvHour);
        var tvMinute = findViewById<TextView>(R.id.tvMinute);

        //onCreate()영역
        //처음 무조건 실행
        cv.visibility = View.INVISIBLE
        tp.visibility = View.INVISIBLE

        var selectYear : Int = 0
        var selectMonth : Int = 0
        var selectDay : Int = 0

        btnStart.setOnClickListener { 
            chrono.base = SystemClock.elapsedRealtime()//시간 초기화
            chrono.start()
            chrono.setTextColor(Color.RED)
        }

        rdoDate.setOnClickListener {
            cv.visibility = View.VISIBLE
            tp.visibility = View.INVISIBLE
        }

        rdoTime.setOnClickListener {
            cv.visibility = View.INVISIBLE
            tp.visibility = View.VISIBLE
        }

        btnFinish.setOnClickListener {
            //년,월,일 , 시,분 을
            tvYear.text = selectYear.toString() //년
            tvMonth.text = selectMonth.toString()//월
            tvDay.text = selectDay.toString()//일

            tvHour.text = tp.currentHour.toString()//시
            tvMinute.text = tp.currentMinute.toString()//분
        }

        cv.setOnDateChangeListener { calendarView, year, month, day ->
            selectYear = year
            selectMonth = month + 1
            selectDay = day
        }

    }
}