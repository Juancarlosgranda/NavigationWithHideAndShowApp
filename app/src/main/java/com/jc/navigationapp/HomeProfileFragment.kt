package com.jc.navigationapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home_profile.*
import kotlin.math.log

/**
 * Created by Christopher Elias on 16/09/2019.
 * celias@peruapps.com.pe
 *
 * Peru Apps
 * Lima, Peru.
 **/
class HomeProfileFragment :  Fragment() {

    private var result = MutableLiveData<String>("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { key, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            result.value = bundle.getString("bundleKey")
            // Do something with the result...
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater.inflate(R.layout.fragment_home_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAction.setOnClickListener {
            showHomeOtherFragment()
        }
        result.observe(viewLifecycleOwner, Observer {
            tvResult.text = it
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("cuack","onDestroy" )

    }

    private fun showHomeOtherFragment() {
        fragmentManager?.beginTransaction()
            ?.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            ?.add(R.id.frame_home_container, HomeOthersFragment(), "HomeOthersFragment" )
            ?.addToBackStack(null)
            ?.commit()
    }
}