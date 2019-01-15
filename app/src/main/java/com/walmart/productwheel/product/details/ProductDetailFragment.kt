package com.walmart.productwheel.product.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R

class ProductDetailFragment () : Fragment() {

    // Vars
    lateinit var vew : View

    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        vew = inflater.inflate(R.layout.product_detail_fragment,container,false)

        // Set up the view pager.
        var viewPager = vew.findViewById<ViewPager>(R.id.productPager)
        if (viewPager != null) {
            var productPagerAdapter = ProductDetailPagerAdapter(fragmentManager)
            viewPager.adapter = productPagerAdapter;
            viewPager.setCurrentItem(MainActivity.instance.position,  true)
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                override fun onPageScrollStateChanged(state: Int) {
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }
                override fun onPageSelected(pos: Int) {
                    // Move product position to where we just swiped.
                    MainActivity.instance.position = pos;
                }
            })
        }

        // Return the fragment view/layout
        return vew
    }
}