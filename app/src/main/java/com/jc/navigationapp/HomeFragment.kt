package com.jc.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Christopher Elias on 16/09/2019.
 * celias@peruapps.com.pe
 *
 * Peru Apps
 * Lima, Peru.
 **/
class HomeFragment :  Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAction.setOnClickListener {
            showHomeProfileFragment()
        }
    }
    private fun showHomeProfileFragment() {
        fragmentManager?.beginTransaction()
            ?.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            ?.add(R.id.frame_home_container, HomeProfileFragment(), "HomeProfileFragment")
            ?.addToBackStack(null)
            ?.commit()
    }
}