package com.walmart.productwheel

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

open class RootFragment : Fragment() {

    var activityMain: MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityMain = context as MainActivity
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString() + " must implement MainActivity")
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}