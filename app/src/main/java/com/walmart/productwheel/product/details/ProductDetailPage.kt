package com.walmart.productwheel.product.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import com.walmart.productwheel.RootFragment
import com.walmart.productwheel.product.list.ProductListFragment

internal class ProductDetailPage (): RootFragment() {

    // Vars.
    lateinit var showProdListBtn    : Button
    lateinit var productName        : TextView
    var page = MainActivity.instance.position

    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.product_detail_page, container, false)

        productName     = view.findViewById(R.id.productName)
        showProdListBtn = view.findViewById<Button>(R.id.showProdListBtn)
        showProdListBtn.setOnClickListener(
            {
                MainActivity.instance.showFragment(ProductListFragment())
            }
        )
        bind ()

        return view;
    }

    /**
     * bind
     */
    fun bind ()
    {
        productName.text = MainActivity.instance.getProduct (page).productName
    }
}