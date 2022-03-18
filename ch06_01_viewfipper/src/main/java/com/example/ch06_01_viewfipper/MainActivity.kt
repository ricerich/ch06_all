package com.example.ch06_01_viewfipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrev : Button
        var btnNext : Button
        var vFlipper : ViewFlipper

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        vFlipper.flipInterval = 1000

        btnPrev.setOnClickListener {
//            vFlipper.showPrevious()
            vFlipper.startFlipping()

        }

        btnNext.setOnClickListener {
//            vFlipper.showNext()
            vFlipper.stopFlipping()
        }
    }
}
