package com.example.ch06_03_actionbar_fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {

    //1.탭 선언
    lateinit var tab1 : ActionBar.Tab
    lateinit var tab2 : ActionBar.Tab
    lateinit var tab3 : ActionBar.Tab

    //2.프래그먼트를 담은 배열 선언(3개 짜리)
    var fragArr = arrayOfNulls<MyFragment>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //View 대신 Fragmnet쓸꺼임 (kotlin객체로, xml아님)
//        setContentView(R.layout.activity_main)

        //1번 액션바 만들기
        var bar = this.supportActionBar//액티비티 지가 가지고 있는 bar를 꺼낸다.
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        //2번 탭 만들기
        var tab1 = bar.newTab()//탭만들기
        tab1.text = "음악별"//탭이름 설정
        //tab1.setOnTouchListener(리스너)
        tab1.setTabListener(this)
        bar.addTab(tab1)//bar에다가 탭 달기기

        var tab2 = bar.newTab()//탭만들기
        tab2.text = "가수별"//탭이름 설정
        //tab2.setOnTouchListener(리스너)
        tab2.setTabListener(this)
        bar.addTab(tab2)//bar에다가 탭 달기기

        var tab3 = bar.newTab()//탭만들기
        tab3.text = "앨범별"//탭이름 설정
        //tab3.setOnTouchListener(리스너)
        tab3.setTabListener(this)
        bar.addTab(tab3)//bar에다가 탭 달기기

        //3.프레그먼트(콘텐츠) 만들기 -view아님, 비교해볼껏
        //밑에서 만듦
        

    }

    override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        var myFrag1 : MyFragment? = null

        if(fragArr[tab!!.position] == null)//프래그먼트배열에 프레그먼트가 없으면, 즉 처음 탭을 클릭한거면~! 프래그1을 만들어야함
        {
            myFrag1 = MyFragment()//배열안에 없으면, 프레그먼트를 새로 만든다
            var data1 = Bundle()
            data1.putString("tabName", tab.text.toString())//번들에 key와 valu를 설정해서 보낼꺼임
            myFrag1.arguments = data1//OS에 번들로 보낸다
            fragArr[tab.position] = myFrag1
        }
        else //배열안에 프래그먼트가 있으면
        {
            myFrag1 = fragArr[tab.position]//배열안에 있는 프래그먼트를 꺼낸다.
        }

        ft!!.replace(android.R.id.content, myFrag1!!)//중요: 보여줄 프레그먼트를 교체한다~

    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    //내부 클래스로 만든다. 프래그먼트를~! (물론, 외부클래스로, activity 클래스랑 동급으로 만들어됨!
    class MyFragment : Fragment()
    {
        //2단계 만드는 절차
        //1단계.onCreate()     메소드 구현(재정의, override)
        //2단계.onCreateView() 메소드 구현(재정의, override)

        //멤버변수로 격상
        var tabName : String? = null
        //1단계.onCreate()     메소드 구현(재정의, override)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //역할: 나는 프레그먼트 생성(onCreate), "액션바의 탭"과 연결
            var data1 = arguments//아규먼트? 비슷한게, 매개변수의 일종... 예를들면 자바에서-> public static void main(String[] args)
            tabName = data1!!.getString("tabName")//OS에 설정된 tabName을 가져온다.(정확히는 OS가 가지고 있는 액션바의 탭의 tabName)
            //tabName은 Fragment의 View를 만들때 쓸꺼임~!
        }

        //2단계.onCreateView() 메소드 구현(재정의, override)
        override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View? {

            //Fragment의 View를 만듦
            //리니어로 만들꺼임(xml아니고요, kotlin코드로 만들꺼임), 아직 inflater 개념을 모르므로 그냥 kotlin객체로 view 만듦
            var option = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                   LinearLayout.LayoutParams.MATCH_PARENT)
            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = option
            
            if(tabName == "음악별")
                baseLayout.setBackgroundColor(Color.RED)
            else if(tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN)
            else if(tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE)

//            setContenView(baseLayout, option)//이런 방식은 Activity 에 꽂을때고..

//            return super.onCreateView(inflater, container, savedInstanceState)
            return baseLayout
        }
    }


}










