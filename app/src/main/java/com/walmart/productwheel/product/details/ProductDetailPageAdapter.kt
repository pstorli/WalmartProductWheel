package com.walmart.productwheel.product.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.walmart.productwheel.MainActivity

class ProductDetailPagerAdapter (fm: androidx.fragment.app.FragmentManager?) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {

    /**
     * getItem
     */
    override fun getItem (position: Int): androidx.fragment.app.Fragment? {
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
