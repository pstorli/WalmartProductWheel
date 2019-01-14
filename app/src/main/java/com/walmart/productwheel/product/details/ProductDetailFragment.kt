package com.walmart.productwheel.product.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.walmart.productwheel.R
import com.walmart.productwheel.RootFragment
import com.walmart.productwheel.product.Product
import com.walmart.productwheel.product.list.ProductListFragment

class ProductDetailFragment () : RootFragment() {

    // Vars
    lateinit var vew            : View
    lateinit var productName    : TextView
             var product        : Product? = null

    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        vew = inflater!!.inflate(R.layout.product_detail_fragment,container,false)

        // The product name.
        productName = vew.findViewById<TextView>(R.id.productName);
        if (null != product) productName.text = product!!.name

        // The show product ist button.
        val button2 = vew.findViewById<Button>(R.id.showProdListBtn)
        button2.setOnClickListener {

            // Show Product List
            activityMain?.showFragment(ProductListFragment());
        }

        // Return the fragment view/layout
        return vew
    }

    /**
     * Set the product to display.
     */
    fun product (product:Product)
    {
        this.product = product

        if (::productName.isInitialized) productName.text = product.name

        if (::vew.isInitialized) vew.invalidate()

    }
}