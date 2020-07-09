package com.jc.navigationapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_home_other.*

/**
 * Created by Christopher Elias on 16/09/2019.
 * celias@peruapps.com.pe
 *
 * Peru Apps
 * Lima, Peru.
 **/
class HomeOthersFragment :  Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater.inflate(R.layout.fragment_home_other, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAction.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("bundleKey" to etOther.text.toString()))
            Log.d("cuack","send ${etOther.text}" )
            activity?.onBackPressed()
        }
    }
}