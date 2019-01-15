package com.walmart.productwheel

import android.support.v4.app.Fragment
import com.walmart.productwheel.product.io.Product

open class RootFragment : Fragment() {

    /**
     * getProduct
     */
    fun getProduct (pos:Int) : Product
    {
        return MainActivity.instance.getProduct (pos)
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