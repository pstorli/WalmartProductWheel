package com.walmart.productwheel.product.details

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.walmart.productwheel.MainActivity

class ProductDetailPagerAdapter (fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    /**
     * getItem
     */
    override fun getItem (position: Int): Fragment? {
        val pdp = ProductDetailPage ()
        pdp.page = position

        return pdp
    }

    /**
     * getCount
     */
    override fun getCount(): Int {
        return MainActivity.instance.getProductCount ()
    }
}
