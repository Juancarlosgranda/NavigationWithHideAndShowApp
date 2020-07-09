package com.jc.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu_notifications.*

/**
 * Created by Christopher Elias on 16/09/2019.
 * celias@peruapps.com.pe
 *
 * Peru Apps
 * Lima, Peru.
 **/
class MenuNotificationsFragment :  Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater.inflate(R.layout.fragment_menu_notifications, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAction.setOnClickListener {
            showMenuSettingsFragment()
        }
    }
    private fun showMenuSettingsFragment() {
        fragmentManager?.beginTransaction()
            ?.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            ?.add(R.id.frame_menu_container, MenuSettingsFragment(), "MenuSettingsFragment")
            ?.addToBackStack(null)
            ?.commit()
    }
}