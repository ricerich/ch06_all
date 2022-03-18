package com.example.ch06_all

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt1 = findViewById<EditText>(R.id.edtUrl)
        var btn1 = findViewById<Button>(R.id.btnGo)
        var btn2 = findViewById<Button>(R.id.btnBack)

        var webView1 = findViewById<WebView>(R.id.webView1)

        //중요:
        //1.웹뷰클라이언트를 만든다!
        //2.웹뷰클라이언트를 웹뷰에 꽂는다!


        //1.웹뷰클라이언트를 만든다!
        class MyWebViewClient : WebViewClient()
        {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return super.shouldOverrideUrlLoading(view, url)
            }
        }

        var webViewClient1 = MyWebViewClient()

        //2.웹뷰클라이언트를 웹뷰에 꽂는다!
        webView1.webViewClient = webViewClient1



        btn1.setOnClickListener {
            //edt1.text
            webView1.loadUrl(edt1.text.toString())
        }


    }
}