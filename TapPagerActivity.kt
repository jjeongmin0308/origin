package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout

class TapPagerActivity : AppCompatActivity() {
    val tap_layout : com.google.android.material.tabs.TabLayout = findViewById(R.id.tap_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tap_pager)


        tap_layout.addTab(tap_layout.newTab().setText("ONE"))
        tap_layout.addTab(tap_layout.newTab().setText("TWO"))
        tap_layout.addTab(tap_layout.newTab().setText("THREE"))

        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        val view_pager : androidx.viewpager.widget.ViewPager = findViewById(R.id.view_pager)
        view_pager.adapter = pagerAdapter

        tap_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tap_layout))


    }
}

class PagerAdapter(
    fragmentManager : FragmentManager,
    val tapCount: Int
):FragmentStatePagerAdapter (fragmentManager) {
    override fun getCount(): Int {
        return tapCount
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            else -> {
                return Fragment1()
            }
        }
    }

}
