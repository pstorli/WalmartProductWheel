package com.walmart.productwheel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ProductListFragment : RootFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        val view = inflater!!.inflate(R.layout.product_list_fragment,container,false)

        val button1 = view.findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            activityMain?.showFragment (ProductDetailFragment());
        }

        // Return the fragment view/layout
        return view
    }
}