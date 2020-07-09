package com.jc.navigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeContainerFragment = HomeContainerFragment()
    private var menuContainerFragment = MenuContainerFragment()
    private var activeFragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragments()
        setUpListeners()
    }

    private fun addFragments() {
        activeFragment = homeContainerFragment
        supportFragmentManager.beginTransaction()
            .add(R.id.mainFrame, menuContainerFragment, "menuContainerFragment").hide(menuContainerFragment)
            .add(R.id.mainFrame, homeContainerFragment, "homeContainerFragment")
            .commit()
    }

    private fun hideAndShowFragment(fragmentToShow: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragmentToShow)
            .commit()
        activeFragment = fragmentToShow
    }

    private fun setUpListeners() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.page_1) {
                hideAndShowFragment(homeContainerFragment)
            } else {
                hideAndShowFragment(menuContainerFragment)
            }
            true
        }

    }
}
