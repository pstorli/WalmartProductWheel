package com.walmart.productwheel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ProductDetailFragment () : RootFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        val view = inflater!!.inflate(R.layout.product_detail_fragment,container,false)

        val button2 = view.findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            activityMain?.showFragment (ProductListFragment());
        }

        // Return the fragment view/layout
        return view
    }
}