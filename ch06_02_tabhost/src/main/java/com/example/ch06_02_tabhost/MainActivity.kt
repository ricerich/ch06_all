package com.example.ch06_02_tabhost

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec

@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.탭호스트를 가져온다. 반드시 tabActivity로 상속받아야 한다.
        //2.탭스펙(메뉴) 객체를 만든다
        //3.콘텐츠를 메뉴에 붙인다.
        //4.메뉴를 탭호스트에 붙인다.


        //1.탭호스트를 가져온다. 반드시 tabActivity로 상속받아야 한다.
        var tabHost = this.tabHost

        //2.탭스펙(메뉴) 객체를 만든다
        var tab1 = tabHost.newTabSpec("DOG").setIndicator("강아지")
        //3.콘텐츠를 메뉴에 붙인다.
        tab1.setContent(R.id.iv1)
        //4.메뉴를 탭호스트에 붙인다.
        tabHost.addTab(tab1)

        var tab2 = tabHost.newTabSpec("CAT").setIndicator("고양이")
        tab2.setContent(R.id.iv2)
        tabHost.addTab(tab2)

        var tab3 = tabHost.newTabSpec("RABBIT").setIndicator("토끼")
        tab3.setContent(R.id.iv3)
        tabHost.addTab(tab3)

        var tab4 = tabHost.newTabSpec("HORSE").setIndicator("말")
        tab4.setContent(R.id.iv4)
        tabHost.addTab(tab4)

        tabHost.currentTab = 1




//        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
//        tabSpecSong.setContent(R.id.tabSong)
//        tabHost.addTab(tabSpecSong)
//
//        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
//        tabSpecArtist.setContent(R.id.tabArtist)
//        tabHost.addTab(tabSpecArtist)
//
//        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
//        tabSpecAlbum.setContent(R.id.tabAlbum)
//        tabHost.addTab(tabSpecAlbum)
//
//        tabHost.currentTab = 0
    }
}